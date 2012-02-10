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
package org.hibernate.search.backend.impl.lucene;

import java.util.Collections;
import java.util.concurrent.locks.Lock;

import org.apache.lucene.index.IndexWriter;
import org.hibernate.search.backend.IndexingMonitor;
import org.hibernate.search.backend.LuceneWork;
import org.hibernate.search.backend.impl.lucene.works.LuceneWorkVisitor;
import org.hibernate.search.batchindexing.impl.FlushableExecutor;
import org.hibernate.search.exception.ErrorHandler;
import org.hibernate.search.exception.impl.ErrorContextBuilder;
import org.hibernate.search.util.logging.impl.Log;
import org.hibernate.search.util.logging.impl.LoggerFactory;

/**
 * Version of LuceneBackendQueueTask meant for streaming operations only,
 * so single operations instead of queues and to reuse this same instance
 * multiple times.
 * Since this implementation is not async, the ErrorContextBuilder is not
 * applied; this should be wrapping the invoker code, as it does for example
 * in the MassIndexer.
 * 
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2012 Red Hat Inc.
 */
final class LuceneBackendTaskStreamer {

	private static final Log log = LoggerFactory.make();

	private final LuceneWorkVisitor workVisitor;
	private final Lock modificationLock;
	private final AbstractWorkspaceImpl workspace;
	private final FlushableExecutor workersExecutor;
	private final ErrorHandler errorHandler;

	public LuceneBackendTaskStreamer(LuceneBackendResources resources) {
		this.workVisitor = resources.getVisitor();
		this.workspace = resources.getWorkspace();
		this.modificationLock = resources.getParallelModificationLock();
		this.workersExecutor = resources.getWorkersExecutor();
		this.errorHandler = resources.getErrorHandler();
	}

	public void doWork(final LuceneWork work, final IndexingMonitor monitor) {
		workersExecutor.execute( new StreamingTaskRunnable( work, monitor ) );
	}

	private final class StreamingTaskRunnable implements Runnable {

		private final LuceneWork work;
		private final IndexingMonitor monitor;

		StreamingTaskRunnable(final LuceneWork work, final IndexingMonitor monitor) {
			this.work = work;
			this.monitor = monitor;
		}

		@Override
		public void run() {
			modificationLock.lock();
			try {
				IndexWriter indexWriter = workspace.getIndexWriter();
				if ( indexWriter == null ) {
					log.cannotOpenIndexWriterCausePreviousError();
					return;
				}
				boolean errors = true;
				try {
					work.getWorkDelegate( workVisitor ).performWork( work, indexWriter, monitor );
					errors = false;
				}
				catch (RuntimeException re) {
					errorHandler.handle( new ErrorContextBuilder()
						.allWorkToBeDone( Collections.singletonList( work ) )
						.errorThatOccurred( re )
						.addAllWorkThatFailed( Collections.singletonList( work ) )
						.createErrorContext()
					);
				}
				finally {
					workspace.afterTransactionApplied( errors, true );
				}
			}
			finally {
				modificationLock.unlock();
			}
		}

	}

}
