/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.impl;

import java.util.Optional;

import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.BeanRetrieval;
import org.hibernate.search.mapper.pojo.extractor.mapping.annotation.ContainerExtraction;
import org.hibernate.search.mapper.pojo.extractor.mapping.programmatic.ContainerExtractorPath;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.ObjectPath;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.processing.MappingAnnotationProcessorContext;
import org.hibernate.search.mapper.pojo.model.path.PojoModelPathValueNode;
import org.hibernate.search.util.common.reflect.spi.AnnotationHelper;

public abstract class AbstractMappingAnnotationProcessorContext
		implements MappingAnnotationProcessorContext {

	protected final AnnotationHelper annotationHelper;

	protected AbstractMappingAnnotationProcessorContext(AnnotationHelper annotationHelper) {
		this.annotationHelper = annotationHelper;
	}

	@Override
	public Optional<PojoModelPathValueNode> toPojoModelPathValueNode(ObjectPath objectPath) {
		return MappingAnnotationProcessorUtils.toPojoModelPathValueNode( objectPath );
	}

	@Override
	public ContainerExtractorPath toContainerExtractorPath(ContainerExtraction extraction) {
		return MappingAnnotationProcessorUtils.toContainerExtractorPath( extraction );
	}

	@Override
	public <T> Optional<BeanReference<? extends T>> toBeanReference(Class<T> expectedType, Class<?> undefinedTypeMarker,
			Class<? extends T> type, String name, BeanRetrieval retrieval) {
		return MappingAnnotationProcessorUtils.toBeanReference( expectedType, undefinedTypeMarker, type, name, retrieval );
	}

}
