/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.lucene.search.query.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.hibernate.search.backend.lucene.logging.impl.Log;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.MetadataFields;
import org.hibernate.search.backend.lucene.orchestration.impl.LuceneSyncWorkOrchestrator;
import org.hibernate.search.backend.lucene.search.aggregation.impl.AggregationRequestContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregation;
import org.hibernate.search.backend.lucene.search.extraction.impl.ExtractionRequirements;
import org.hibernate.search.backend.lucene.lowlevel.query.impl.Queries;
import org.hibernate.search.backend.lucene.search.impl.LuceneSearchContext;
import org.hibernate.search.backend.lucene.search.impl.LuceneSearchQueryElementCollector;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjection;
import org.hibernate.search.backend.lucene.search.projection.impl.SearchProjectionRequestContext;
import org.hibernate.search.backend.lucene.search.query.LuceneSearchQuery;
import org.hibernate.search.backend.lucene.types.sort.comparatorsource.impl.LuceneFieldComparatorSource;
import org.hibernate.search.backend.lucene.work.impl.LuceneWorkFactory;
import org.hibernate.search.engine.backend.session.spi.BackendSessionContext;
import org.hibernate.search.engine.search.aggregation.AggregationKey;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContext;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.engine.search.query.spi.SearchQueryBuilder;
import org.hibernate.search.engine.search.timeout.spi.TimeoutManager;
import org.hibernate.search.util.common.logging.impl.LoggerFactory;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;

public class LuceneSearchQueryBuilder<H>
		implements SearchQueryBuilder<H, LuceneSearchQueryElementCollector>, LuceneSearchQueryElementCollector {

	private static final Log log = LoggerFactory.make( Log.class, MethodHandles.lookup() );

	private final LuceneWorkFactory workFactory;
	private final LuceneSyncWorkOrchestrator queryOrchestrator;

	private final LuceneSearchContext searchContext;
	private final BackendSessionContext sessionContext;
	private final Set<String> routingKeys;

	private final SearchLoadingContextBuilder<?, ?, ?> loadingContextBuilder;
	private final LuceneSearchProjection<?, H> rootProjection;

	private List<LuceneFieldComparatorSource> nestedFieldSorts;

	private Query luceneQuery;
	private List<SortField> sortFields;
	private Map<AggregationKey<?>, LuceneSearchAggregation<?>> aggregations;
	private Long timeout;
	private TimeUnit timeUnit;
	private boolean exceptionOnTimeout;
	private Long totalHitCountThreshold;

	public LuceneSearchQueryBuilder(
			LuceneWorkFactory workFactory,
			LuceneSyncWorkOrchestrator queryOrchestrator,
			LuceneSearchContext searchContext,
			BackendSessionContext sessionContext,
			SearchLoadingContextBuilder<?, ?, ?> loadingContextBuilder,
			LuceneSearchProjection<?, H> rootProjection) {
		this.workFactory = workFactory;
		this.queryOrchestrator = queryOrchestrator;

		this.searchContext = searchContext;
		this.sessionContext = sessionContext;
		this.routingKeys = new HashSet<>();

		this.loadingContextBuilder = loadingContextBuilder;
		this.rootProjection = rootProjection;
	}

	@Override
	public LuceneSearchQueryElementCollector toQueryElementCollector() {
		return this;
	}

	@Override
	public void addRoutingKey(String routingKey) {
		this.routingKeys.add( routingKey );
	}

	@Override
	public void truncateAfter(long timeout, TimeUnit timeUnit) {
		// This will override any failAfter. Eventually we could allow the user to set both.
		this.timeout = timeout;
		this.timeUnit = timeUnit;
		this.exceptionOnTimeout = false;
	}

	@Override
	public void failAfter(long timeout, TimeUnit timeUnit) {
		// This will override any truncateAfter. Eventually we could allow the user to set both.
		this.timeout = timeout;
		this.timeUnit = timeUnit;
		this.exceptionOnTimeout = true;
	}

	@Override
	public void totalHitCountThreshold(long totalHitCountThreshold) {
		this.totalHitCountThreshold = totalHitCountThreshold;
	}

	@Override
	public void collectPredicate(Query luceneQuery) {
		this.luceneQuery = luceneQuery;
	}

	@Override
	public void collectSortField(SortField sortField) {
		if ( sortFields == null ) {
			sortFields = new ArrayList<>( 5 );
		}
		sortFields.add( sortField );
	}

	@Override
	public void collectSortField(SortField sortField, LuceneFieldComparatorSource nestedFieldSort) {
		collectSortField( sortField );
		if ( nestedFieldSort == null ) {
			return;
		}

		if ( nestedFieldSorts == null ) {
			nestedFieldSorts = new ArrayList<>( 5 );
		}
		nestedFieldSorts.add( nestedFieldSort );
	}

	@Override
	public void collectSortFields(SortField[] sortFields) {
		if ( sortFields == null || sortFields.length == 0 ) {
			return;
		}

		if ( this.sortFields == null ) {
			this.sortFields = new ArrayList<>( sortFields.length );
		}
		Collections.addAll( this.sortFields, sortFields );
	}

	@Override
	public <A> void collectAggregation(AggregationKey<A> key, LuceneSearchAggregation<A> aggregation) {
		if ( aggregations == null ) {
			aggregations = new LinkedHashMap<>();
		}
		Object previous = aggregations.put( key, aggregation );
		if ( previous != null ) {
			throw log.duplicateAggregationKey( key );
		}
	}

	@Override
	public LuceneSearchQuery<H> build() {
		SearchLoadingContext<?, ?> loadingContext = loadingContextBuilder.build();

		BooleanQuery.Builder luceneQueryBuilder = new BooleanQuery.Builder();
		luceneQueryBuilder.add( luceneQuery, Occur.MUST );
		if ( searchContext.indexes().hasNestedDocuments() ) {
			// HSEARCH-4018: this filter has a (small) cost, so we only add it if necessary.
			luceneQueryBuilder.add( Queries.mainDocumentQuery(), Occur.FILTER );
		}
		if ( !routingKeys.isEmpty() ) {
			Query routingKeysQuery = Queries.anyTerm( MetadataFields.routingKeyFieldName(), routingKeys );
			luceneQueryBuilder.add( routingKeysQuery, Occur.FILTER );
		}

		Query filter = searchContext.filterOrNull( sessionContext.tenantIdentifier() );
		if ( filter != null ) {
			luceneQueryBuilder.add( filter, BooleanClause.Occur.FILTER );
		}

		Query definitiveLuceneQuery = luceneQueryBuilder.build();

		Sort luceneSort = null;
		if ( sortFields != null && !sortFields.isEmpty() ) {
			luceneSort = new Sort( sortFields.toArray( new SortField[0] ) );
		}

		if ( nestedFieldSorts != null ) {
			for ( LuceneFieldComparatorSource nestedField : nestedFieldSorts ) {
				nestedField.setOriginalParentQuery( definitiveLuceneQuery );
			}
		}

		LuceneSearchQueryRequestContext requestContext = new LuceneSearchQueryRequestContext(
				sessionContext, loadingContext, definitiveLuceneQuery, luceneSort
		);

		ExtractionRequirements.Builder extractionRequirementsBuilder = new ExtractionRequirements.Builder();
		SearchProjectionRequestContext projectionRequestContext =
				new SearchProjectionRequestContext( extractionRequirementsBuilder );
		rootProjection.request( projectionRequestContext );
		if ( aggregations != null ) {
			AggregationRequestContext aggregationRequestContext =
					new AggregationRequestContext( extractionRequirementsBuilder );
			for ( LuceneSearchAggregation<?> aggregation : aggregations.values() ) {
				aggregation.request( aggregationRequestContext );
			}
		}
		ExtractionRequirements extractionRequirements = extractionRequirementsBuilder.build();

		TimeoutManager timeoutManager = searchContext.createTimeoutManager( timeout, timeUnit, exceptionOnTimeout );

		LuceneSearcherImpl<H> searcher = new LuceneSearcherImpl<>(
				requestContext,
				rootProjection,
				aggregations == null ? Collections.emptyMap() : aggregations,
				extractionRequirements,
				timeoutManager
		);

		return new LuceneSearchQueryImpl<>(
				queryOrchestrator, workFactory,
				searchContext,
				sessionContext,
				loadingContext,
				routingKeys,
				timeoutManager,
				definitiveLuceneQuery,
				luceneSort,
				searcher, totalHitCountThreshold
		);
	}
}
