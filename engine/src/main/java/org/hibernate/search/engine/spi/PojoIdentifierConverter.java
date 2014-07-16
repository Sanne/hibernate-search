/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.engine.spi;

import org.hibernate.search.spi.IndexedEntityTypeIdentifier;


/**
 * PojoIdentifierConverter.
 * 
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2014 Red Hat Inc.
 * @since 5.0
 */
public final class PojoIdentifierConverter implements IdentifierConverter<Class<?>> {

	//TODO make this a service
	public static final IdentifierConverter INSTANCE = new PojoIdentifierConverter();

	@Override
	public IndexedEntityTypeIdentifier convertEntityIdentifier(Class<?> entityClass) {
		//TODO
		return null;
	}

	@Override
	public IndexedEntityTypeIdentifier fromName(String entityClassName) {
		//TODO
		return null;
	}

	@Override
	public Class<?> inverseConversion(IndexedEntityTypeIdentifier key) {
		//TODO
		return null;
	}

}
