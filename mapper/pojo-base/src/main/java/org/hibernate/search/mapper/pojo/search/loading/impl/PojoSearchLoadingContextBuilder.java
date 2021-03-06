/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.mapper.pojo.search.loading.impl;

import java.util.Map;

import org.hibernate.search.engine.backend.common.spi.DocumentReferenceConverter;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContext;
import org.hibernate.search.engine.search.loading.spi.SearchLoadingContextBuilder;
import org.hibernate.search.mapper.pojo.bridge.runtime.spi.BridgeSessionContext;
import org.hibernate.search.mapper.pojo.loading.spi.PojoLoadingContextBuilder;

public class PojoSearchLoadingContextBuilder<R, E, LOS> implements SearchLoadingContextBuilder<R, E, LOS> {

	private final Map<String, PojoSearchLoadingIndexedTypeContext<? extends E>> targetTypesByEntityName;
	private final DocumentReferenceConverter<R> documentReferenceConverter;
	private final BridgeSessionContext sessionContext;
	private final PojoLoadingContextBuilder<LOS> delegate;

	public PojoSearchLoadingContextBuilder(
			Map<String, PojoSearchLoadingIndexedTypeContext<? extends E>> targetTypesByEntityName,
			DocumentReferenceConverter<R> documentReferenceConverter,
			BridgeSessionContext sessionContext,
			PojoLoadingContextBuilder<LOS> delegate) {
		this.targetTypesByEntityName = targetTypesByEntityName;
		this.documentReferenceConverter = documentReferenceConverter;
		this.sessionContext = sessionContext;
		this.delegate = delegate;
	}

	@Override
	public LOS toAPI() {
		return delegate.toAPI();
	}

	@Override
	public SearchLoadingContext<R, E> build() {
		return new PojoSearchLoadingContext<>( targetTypesByEntityName, documentReferenceConverter, sessionContext,
				delegate.build() );
	}
}
