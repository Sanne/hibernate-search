/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

package org.hibernate.search.test.performance.nrt;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.search.Query;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Latitude;
import org.hibernate.search.annotations.Longitude;
import org.hibernate.search.annotations.ProvidedId;
import org.hibernate.search.annotations.Spatial;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.backend.spi.Work;
import org.hibernate.search.backend.spi.WorkType;
import org.hibernate.search.backend.spi.Worker;
import org.hibernate.search.batchindexing.impl.ProducerConsumerQueue;
import org.hibernate.search.cfg.Environment;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.Unit;
import org.hibernate.search.query.engine.spi.EntityInfo;
import org.hibernate.search.spi.SearchIntegrator;
import org.hibernate.search.test.util.TargetDirHelper;
import org.hibernate.search.testsupport.TestConstants;
import org.hibernate.search.testsupport.TestForIssue;
import org.hibernate.search.testsupport.junit.SearchFactoryHolder;
import org.hibernate.search.testsupport.setup.TransactionContextForTest;
import org.hibernate.search.util.impl.Executors;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

@TestForIssue(jiraKey = "HSEARCH-")
public class BoundariesScoringTest {

	private static final Boolean PERFORMANCE_ENABLED = true;//TestConstants.arePerformanceTestsEnabled();

	private static final int THREAD_NUMBER = PERFORMANCE_ENABLED ? 16 : 1;

	private static final int WARM_UP_SECONDS = PERFORMANCE_ENABLED ? 120 : 1;
	private static final int FULL_RUN_SECONDS = PERFORMANCE_ENABLED ? WARM_UP_SECONDS * 10 : 1;

	private static final AtomicBoolean failures = new AtomicBoolean( false );
	private static final AtomicBoolean running = new AtomicBoolean( true );
	private static final AtomicInteger cyclesCompleted = new AtomicInteger( 0 );

	@Rule
	public SearchFactoryHolder sfHolder = new SearchFactoryHolder( NamedCoordinates.class )
		.withProperty( "hibernate.search.default.indexmanager", "near-real-time" )
		.withProperty( "hibernate.search.default.indexBase", TestConstants.getIndexDirectory( TargetDirHelper.getTargetDir() ) )
		.withProperty( "hibernate.search.default.directory_provider", "filesystem" )
		.withProperty( "hibernate.search.default.worker.execution", "async" )
		;

	@Test
	public void testPropertiesIndexing() throws InterruptedException {
		SearchIntegrator integrator = sfHolder.getSearchFactory();
		ThreadPoolExecutor threadPool = Executors.newFixedThreadPool( THREAD_NUMBER, "BoundariesScoringTest" );
		for ( int i = 0; i < THREAD_NUMBER; i++ ) {
			threadPool.execute( new Task( integrator, i ) );
		}
		threadPool.shutdown();
		try {
			//Time to warmup only:
			threadPool.awaitTermination( WARM_UP_SECONDS, TimeUnit.SECONDS );
			System.out.println( "Warmup complete. Start measuring now.." );
			//Start measuring:
			cyclesCompleted.set( 0 );
			long startMeasurementTime = System.nanoTime();
			threadPool.awaitTermination( FULL_RUN_SECONDS, TimeUnit.SECONDS );
			int doneCycles = cyclesCompleted.get();
			long endMeasurementTime = System.nanoTime();
			Assert.assertFalse( "Some failure happened in Task execution", failures.get() );
			long totalTime = endMeasurementTime - startMeasurementTime;
			long millisecondsElapsedTime = TimeUnit.MILLISECONDS.convert( totalTime, TimeUnit.NANOSECONDS );
			System.out.println( "Completed " + doneCycles + " in " + millisecondsElapsedTime + " milliseconds" );	
		}
		catch (InterruptedException e) {
			running.set( false );
			threadPool.shutdownNow();
		}
		finally {
			running.set( false );
		}
	}

	private static void storeStuff(int sequential, Worker worker) {
		NamedCoordinates newCoord = new NamedCoordinates();
		newCoord.name = "name" + sequential;
		newCoord.latitude = ThreadLocalRandom.current().nextDouble( -10, 100 + 1 );
		newCoord.longitude = ThreadLocalRandom.current().nextDouble( -10, 10 + 1 );
		Work work = new Work( newCoord, newCoord.name, WorkType.ADD, false );
		TransactionContextForTest tc = new TransactionContextForTest();
		worker.performWork( work, tc );
		tc.end();
	}

	private static List<EntityInfo> searchStuffSpatial(SearchIntegrator integrator, double radius, double x, double y) {
		QueryBuilder queryBuilder = integrator.buildQueryBuilder().forEntity( NamedCoordinates.class ).get();
		Query query = queryBuilder
				.spatial()
				.within( radius, Unit.KM )
				.ofLatitude( y )
				.andLongitude( x )
				.createQuery();
		List<EntityInfo> results = integrator.createHSQuery( query, NamedCoordinates.class )
				.queryEntityInfos();
		System.out.println( "found " + results.size() + " results" );
		return results;
	}

	private static class Task implements Runnable {

		private final int threadId;
		private final SearchIntegrator integrator;

		public Task(SearchIntegrator integrator, int threadId) {
			this.integrator = integrator;
			this.threadId = threadId;
		}

		@Override
		public void run() {
			final Worker worker = integrator.getWorker();
			try {
				while ( running.get() ) {
					final int id = cyclesCompleted.incrementAndGet();
					maybe( () -> searchStuffSpatial( integrator, 10000, 103.285, 10.7895 ) );
					maybe( () -> searchStuffSpatial( integrator, 3000, 103.285, 10.88 ) );
					maybe( () -> storeStuff( id, worker ) );
				}
			}
			catch (RuntimeException re) {
				if ( running.get() ) {
					re.printStackTrace();
					failures.set( true );
				}
			}
		}

		private void maybe(Runnable todo) {
			if ( ThreadLocalRandom.current().nextBoolean() ) {
				todo.run();
			}
		}

	}

	@Indexed(index = "coords")
	@Spatial
	@ProvidedId
	public static class NamedCoordinates {

		@Field(store = Store.YES, analyze = Analyze.NO)
		String name;

		@Latitude
		public Double latitude=0.0;

		@Longitude
		public Double longitude=0.0;

	}

}
