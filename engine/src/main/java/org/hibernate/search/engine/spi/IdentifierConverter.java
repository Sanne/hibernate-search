package org.hibernate.search.engine.spi;

import org.hibernate.search.spi.IndexedEntityTypeIdentifier;

public interface IdentifierConverter {

	IndexedEntityTypeIdentifier convertEntityIdentifier(Class<?> entityClass);

	/*
	 * Class<?> entityClass = org.hibernate.search.util.impl.ClassLoaderHelper.classForName(
				entityClassName,
				"entity class",
				searchFactory.getServiceManager()
		);
	 */
	IndexedEntityTypeIdentifier fromName(String entityClassName);

	Class<?> inverseConversion(IndexedEntityTypeIdentifier key);

}
