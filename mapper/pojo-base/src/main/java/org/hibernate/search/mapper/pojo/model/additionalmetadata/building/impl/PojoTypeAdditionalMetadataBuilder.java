/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.mapper.pojo.model.additionalmetadata.building.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.hibernate.search.engine.environment.bean.BeanResolver;
import org.hibernate.search.engine.reporting.spi.ContextualFailureCollector;
import org.hibernate.search.engine.reporting.spi.FailureCollector;
import org.hibernate.search.mapper.pojo.bridge.binding.impl.MarkerBindingContextImpl;
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.MarkerBinder;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorPropertyNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.building.spi.PojoAdditionalMetadataCollectorTypeNode;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoPropertyAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.additionalmetadata.impl.PojoTypeAdditionalMetadata;
import org.hibernate.search.mapper.pojo.model.path.spi.PojoPathsDefinition;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeIdentifier;
import org.hibernate.search.mapper.pojo.model.spi.PojoRawTypeModel;
import org.hibernate.search.mapper.pojo.reporting.impl.PojoEventContexts;

class PojoTypeAdditionalMetadataBuilder implements PojoAdditionalMetadataCollectorTypeNode {

	private final BeanResolver beanResolver;
	private final FailureCollector failureCollector;
	private final PojoRawTypeModel<?> rawTypeModel;

	private PojoEntityTypeAdditionalMetadataBuilder entityTypeMetadataBuilder;
	private PojoIndexedTypeAdditionalMetadataBuilder indexedTypeMetadataBuilder;
	// Use a LinkedHashMap for deterministic iteration
	private final Map<String, PojoPropertyAdditionalMetadataBuilder> propertyBuilders = new LinkedHashMap<>();

	PojoTypeAdditionalMetadataBuilder(BeanResolver beanResolver,
			FailureCollector failureCollector, PojoRawTypeModel<?> rawTypeModel) {
		this.beanResolver = beanResolver;
		this.failureCollector = failureCollector;
		this.rawTypeModel = rawTypeModel;
	}

	@Override
	public ContextualFailureCollector failureCollector() {
		return failureCollector.withContext( PojoEventContexts.fromType( rawTypeModel ) );
	}

	@Override
	public PojoRawTypeIdentifier<?> typeIdentifier() {
		return rawTypeModel.typeIdentifier();
	}

	@Override
	public PojoEntityTypeAdditionalMetadataBuilder markAsEntity(String entityName,
			PojoPathsDefinition pathsDefinition) {
		if ( entityTypeMetadataBuilder == null ) {
			entityTypeMetadataBuilder = new PojoEntityTypeAdditionalMetadataBuilder(
					this, entityName, pathsDefinition );
		}
		else {
			entityTypeMetadataBuilder.checkSameEntity( entityName );
		}
		return entityTypeMetadataBuilder;
	}

	@Override
	public PojoIndexedTypeAdditionalMetadataBuilder markAsIndexed(boolean enabled) {
		if ( indexedTypeMetadataBuilder == null ) {
			indexedTypeMetadataBuilder = new PojoIndexedTypeAdditionalMetadataBuilder( this );
		}
		indexedTypeMetadataBuilder.enabled( enabled );
		return indexedTypeMetadataBuilder;
	}

	@Override
	public PojoAdditionalMetadataCollectorPropertyNode property(String propertyName) {
		return propertyBuilders.computeIfAbsent(
				propertyName,
				ignored -> new PojoPropertyAdditionalMetadataBuilder( this, propertyName )
		);
	}

	Object bindMarker(MarkerBinder binder) {
		MarkerBindingContextImpl bindingContext = new MarkerBindingContextImpl( beanResolver );
		return bindingContext.applyBinder( binder );
	}

	public PojoTypeAdditionalMetadata build() {
		Map<String, PojoPropertyAdditionalMetadata> properties = new HashMap<>();
		for ( Map.Entry<String, PojoPropertyAdditionalMetadataBuilder> entry : propertyBuilders.entrySet() ) {
			properties.put( entry.getKey(), entry.getValue().build() );
		}
		return new PojoTypeAdditionalMetadata(
				entityTypeMetadataBuilder == null ? Optional.empty() : Optional.of( entityTypeMetadataBuilder.build() ),
				indexedTypeMetadataBuilder == null ? Optional.empty() : indexedTypeMetadataBuilder.build(),
				properties
		);
	}
}
