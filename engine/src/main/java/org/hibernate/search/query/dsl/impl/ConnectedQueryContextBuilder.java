/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

package org.hibernate.search.query.dsl.impl;

import java.util.Set;

import org.hibernate.search.exception.SearchException;
import org.hibernate.search.engine.spi.SearchFactoryImplementor;
import org.hibernate.search.query.dsl.EntityContext;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.QueryContextBuilder;
import org.hibernate.search.spi.IndexedEntityTypeIdentifier;
import org.hibernate.search.util.impl.ScopedAnalyzer;

/**
 * Assuming connection with the search factory
 *
 * @author Emmanuel Bernard
 */
public class ConnectedQueryContextBuilder implements QueryContextBuilder {
	private final SearchFactoryImplementor factory;

	public ConnectedQueryContextBuilder(SearchFactoryImplementor factory) {
		this.factory = factory;
	}

	@Override
	public EntityContext forEntity(Class<?> entityType) {
		IndexedEntityTypeIdentifier entityIdentifier = factory.getIdentifierConverter().convertEntityIdentifier( entityType );
		return new HSearchEntityContext( entityIdentifier, factory );
	}

	public final class HSearchEntityContext implements EntityContext {
		private final ScopedAnalyzer queryAnalyzer;
		private final QueryBuildingContext context;

		public HSearchEntityContext(IndexedEntityTypeIdentifier entityType, SearchFactoryImplementor factory) {
			// get a type for meta-data retrieval; if the given type itself is not indexed, one indexed sub-type will
			// be used; note that this allows to e.g. query for fields not present on the given type but on one of its
			// sub-types, but we accept this for now
			IndexedEntityTypeIdentifier indexBoundType = getIndexBoundType( entityType, factory );

			if ( indexBoundType == null ) {
				throw new SearchException( String.format( "Can't build query for type %s which is"
						+ " neither indexed nor has any indexed sub-types.",
						entityType.getName() ) );
			}

			queryAnalyzer = new ScopedAnalyzer( factory.getAnalyzer( indexBoundType ) );
			context = new QueryBuildingContext( factory, queryAnalyzer, indexBoundType );
		}

		/**
		 * Returns the given type itself if it is indexed, otherwise the first found indexed sub-type.
		 *
		 * @param entityType the type of interest
		 * @param factory search factory
		 * @return the given type itself if it is indexed, otherwise the first found indexed sub-type or {@code null} if
		 * neither the given type nor any of its sub-types are indexed
		 */
		private IndexedEntityTypeIdentifier getIndexBoundType(IndexedEntityTypeIdentifier entityType, SearchFactoryImplementor factory) {
			if ( factory.getIndexBinding( entityType ) != null ) {
				return entityType;
			}

			Set<IndexedEntityTypeIdentifier> indexedSubTypes = factory.getIndexedTypesPolymorphic( new IndexedEntityTypeIdentifier[] { entityType } );

			if ( !indexedSubTypes.isEmpty() ) {
				return indexedSubTypes.iterator().next();
			}

			return null;
		}

		@Override
		public EntityContext overridesForField(String field, String analyzerName) {
			queryAnalyzer.addScopedAnalyzer( field, factory.getAnalyzer( analyzerName ) );
			return this;
		}

		@Override
		public QueryBuilder get() {
			return new ConnectedQueryBuilder(context);
		}
	}
}
