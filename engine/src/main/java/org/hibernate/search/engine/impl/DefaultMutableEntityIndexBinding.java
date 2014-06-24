/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.engine.impl;

import java.util.Set;

import org.apache.lucene.search.similarities.Similarity;
import org.hibernate.search.engine.spi.DocumentBuilderIndexedEntity;
import org.hibernate.search.indexes.spi.IndexManager;
import org.hibernate.search.indexes.interceptor.EntityIndexingInterceptor;
import org.hibernate.search.query.collector.impl.FieldCacheCollectorFactory;
import org.hibernate.search.spi.IndexedEntityTypeIdentifier;
import org.hibernate.search.store.IndexShardingStrategy;
import org.hibernate.search.store.ShardIdentifierProvider;

/**
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2011 Red Hat Inc.
 */
public class DefaultMutableEntityIndexBinding<T> implements MutableEntityIndexBinding<T> {

	private final IndexShardingStrategy shardingStrategy;
	private final Similarity similarityInstance;
	private DocumentBuilderIndexedEntity<T> documentBuilder;
	private final IndexManager[] indexManagers;
	private final EntityIndexingInterceptor entityIndexingInterceptor;

	public DefaultMutableEntityIndexBinding(
			IndexShardingStrategy shardingStrategy,
			Similarity similarityInstance,
			IndexManager[] providers,
			EntityIndexingInterceptor<? super T> entityIndexingInterceptor) {
				this.shardingStrategy = shardingStrategy;
				this.similarityInstance = similarityInstance;
				this.indexManagers = providers;
				this.entityIndexingInterceptor = entityIndexingInterceptor;
	}

	@Override
	public void setDocumentBuilderIndexedEntity(DocumentBuilderIndexedEntity<T> documentBuilder) {
		this.documentBuilder = documentBuilder;
	}

	@Override
	public Similarity getSimilarity() {
		return similarityInstance;
	}

	@Override
	public IndexShardingStrategy getSelectionStrategy() {
		return shardingStrategy;
	}

	@Override
	public ShardIdentifierProvider getShardIdentifierProvider() {
		return null;
	}

	@Override
	public DocumentBuilderIndexedEntity<T> getDocumentBuilder() {
		return documentBuilder;
	}

	@Override
	public FieldCacheCollectorFactory getIdFieldCacheCollectionFactory() {
		//TODO remove this stuff from the DocumentBuilder, bring it here.
		return documentBuilder.getIdFieldCacheCollectionFactory();
	}

	@Override
	public void postInitialize(Set<IndexedEntityTypeIdentifier> indexedClasses) {
		documentBuilder.postInitialize( indexedClasses );
	}

	@Override
	public IndexManager[] getIndexManagers() {
		return indexManagers;
	}

	@Override
	public EntityIndexingInterceptor getEntityIndexingInterceptor() {
		return entityIndexingInterceptor;
	}

}
