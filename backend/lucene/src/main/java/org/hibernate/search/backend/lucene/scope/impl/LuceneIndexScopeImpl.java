/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.lucene.scope.impl;

import java.util.Collection;
import java.util.Set;

import org.hibernate.search.backend.lucene.lowlevel.reader.impl.HibernateSearchMultiReader;
import org.hibernate.search.backend.lucene.scope.LuceneIndexScope;
import org.hibernate.search.backend.lucene.scope.model.impl.LuceneScopeIndexManagerContext;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexContext;
import org.hibernate.search.backend.lucene.search.aggregation.impl.LuceneSearchAggregationBuilderFactory;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchIndexScope;
import org.hibernate.search.backend.lucene.search.common.impl.LuceneSearchQueryElementCollector;
import org.hibernate.search.backend.lucene.search.predicate.impl.LuceneSearchPredicateBuilderFactoryImpl;
import org.hibernate.search.backend.lucene.search.projection.impl.LuceneSearchProjectionBuilderFactory;
import org.hibernate.search.backend.lucene.search.query.impl.LuceneSearchQueryBuilderFactory;
import org.hibernate.search.backend.lucene.search.query.impl.SearchBackendContext;
import org.hibernate.search.backend.lucene.search.sort.impl.LuceneSearchSortBuilderFactoryImpl;
import org.hibernate.search.engine.backend.mapping.spi.BackendMappingContext;
import org.hibernate.search.engine.backend.scope.spi.IndexScope;
import org.hibernate.search.engine.search.aggregation.spi.SearchAggregationBuilderFactory;

import org.apache.lucene.index.IndexReader;


public class LuceneIndexScopeImpl
		implements IndexScope<LuceneSearchQueryElementCollector>, LuceneIndexScope {

	private final LuceneSearchIndexScope scope;
	private final LuceneSearchPredicateBuilderFactoryImpl searchPredicateFactory;
	private final LuceneSearchSortBuilderFactoryImpl searchSortFactory;
	private final LuceneSearchQueryBuilderFactory searchQueryFactory;
	private final LuceneSearchProjectionBuilderFactory searchProjectionFactory;
	private final LuceneSearchAggregationBuilderFactory searchAggregationFactory;

	public LuceneIndexScopeImpl(SearchBackendContext backendContext,
			BackendMappingContext mappingContext,
			Set<? extends LuceneScopeIndexManagerContext> indexManagerContexts) {
		this.scope = backendContext.createSearchContext( mappingContext, indexManagerContexts );
		this.searchPredicateFactory = new LuceneSearchPredicateBuilderFactoryImpl( scope );
		this.searchSortFactory = new LuceneSearchSortBuilderFactoryImpl( scope );
		this.searchProjectionFactory = new LuceneSearchProjectionBuilderFactory( scope );
		this.searchAggregationFactory = new LuceneSearchAggregationBuilderFactory( scope );
		this.searchQueryFactory = new LuceneSearchQueryBuilderFactory( backendContext, scope, this.searchProjectionFactory );
	}

	@Override
	public String toString() {
		return new StringBuilder( getClass().getSimpleName() )
				.append( "[" )
				.append( "indexNames=" ).append( scope.hibernateSearchIndexNames() )
				.append( "]" )
				.toString();
	}

	@Override
	public LuceneSearchPredicateBuilderFactoryImpl searchPredicateBuilderFactory() {
		return searchPredicateFactory;
	}

	@Override
	public LuceneSearchSortBuilderFactoryImpl searchSortBuilderFactory() {
		return searchSortFactory;
	}

	@Override
	public LuceneSearchQueryBuilderFactory searchQueryBuilderFactory() {
		return searchQueryFactory;
	}

	@Override
	public LuceneSearchProjectionBuilderFactory searchProjectionFactory() {
		return searchProjectionFactory;
	}

	@Override
	public SearchAggregationBuilderFactory<? super LuceneSearchQueryElementCollector> searchAggregationFactory() {
		return searchAggregationFactory;
	}

	@Override
	public IndexReader openIndexReader(Set<String> routingKeys) {
		Set<String> indexNames = scope.hibernateSearchIndexNames();
		Collection<? extends LuceneSearchIndexContext> indexManagerContexts = scope.indexes();
		return HibernateSearchMultiReader.open( indexNames, indexManagerContexts, routingKeys );
	}
}