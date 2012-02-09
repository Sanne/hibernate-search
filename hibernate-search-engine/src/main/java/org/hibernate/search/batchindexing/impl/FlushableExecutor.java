/* 
 * Hibernate, Relational Persistence for Idiomatic Java
 * 
 * JBoss, Home of Professional Open Source
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.hibernate.search.batchindexing.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


/**
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2012 Red Hat Inc.
 */
public final class FlushableExecutor extends ThreadPoolExecutor {

	private final AtomicReference<CurrentCounter> current = new AtomicReference<CurrentCounter>( new CurrentCounter( null ) );

	public FlushableExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
			ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super( corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler );
	}

	@Override
	public final void execute(final Runnable task) {
		final CurrentCounter currentCounter = current.get();
		currentCounter.increment();
		final Runnable wrappedTask = new RunnableWrap( task, currentCounter );
		super.execute( wrappedTask );
	}

	public final void flush(final long timeout, final TimeUnit unit) throws InterruptedException {
		//This is a new flush operation, so we want to wait for all tasks submitted until now, not after now,
		//so we split the counter to prevent waiting for newly scheduled tasks:
		boolean needGenerationSwap = true;
		final CurrentCounter currentCounter = current.get();
		CurrentCounter toreplaceCounter = currentCounter;
		do { //spin until successful CAS
			CurrentCounter nextGen = toreplaceCounter.nextGen();
			needGenerationSwap = ! current.compareAndSet( toreplaceCounter, nextGen );
			if ( needGenerationSwap ) {
				toreplaceCounter = current.get();
			}
		} while ( needGenerationSwap );
		currentCounter.blockUntilZero( timeout, unit );
	}

	static final class CurrentCounter {

		private final AtomicInteger counter = new AtomicInteger( 0 );
		private final CountDownLatch latch = new CountDownLatch( 1 );
		private volatile CurrentCounter previous;

		CurrentCounter(final CurrentCounter previousGen) {
			this.previous = previousGen;
		}

		public void blockUntilZero(final long timeout, final TimeUnit unit) throws InterruptedException {
			CurrentCounter prev = previous;
			if ( prev != null ) {
				prev.blockUntilZero( timeout, unit );
				previous = null;
			}
			if ( counter.get() > 0 ) {
				latch.await( timeout, unit );
			}
		}

		CurrentCounter nextGen() {
			return new CurrentCounter( this );
		}

		final void decrement() {
			CurrentCounter prev = previous;
			if ( prev != null ) {
				if ( prev.counter.get() == 0 ) {
					previous = null; //release it, we don't need it anymore
				}
			}
			if ( counter.decrementAndGet() == 0 ) {
				//wake up blocked listener, if any
				latch.countDown();
			}
		}

		final void increment() {
			counter.incrementAndGet();
		}

	}

	static final class RunnableWrap implements Runnable {
		private final Runnable task;
		private final CurrentCounter countrun;

		RunnableWrap(final Runnable run, final CurrentCounter countrun) {
			this.task = run;
			this.countrun = countrun;
		}

		@Override
		public void run() {
			try {
				task.run();
			}
			finally {
				countrun.decrement();
			}
		}
	}

}
