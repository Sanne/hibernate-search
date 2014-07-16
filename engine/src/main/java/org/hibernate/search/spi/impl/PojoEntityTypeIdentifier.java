/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.spi.impl;

import org.hibernate.search.spi.IndexedEntityTypeIdentifier;
import org.hibernate.search.util.logging.impl.Log;
import org.hibernate.search.util.logging.impl.LoggerFactory;


/**
 * PojoEntityTypeIdentifier.
 * 
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2014 Red Hat Inc.
 * @since 5.0
 */
public final class PojoEntityTypeIdentifier implements IndexedEntityTypeIdentifier {

	private static final Log log = LoggerFactory.make();

	private final Class<?> pojoType;

	PojoEntityTypeIdentifier(Class<?> pojoType) {
		this.pojoType = pojoType;
	}

	@Override
	public String getName() {
		return pojoType.getName();
	}

	@Override
	public boolean isParentTypeOf(IndexedEntityTypeIdentifier child) {
		//return pojoType.isParentTypeOf( cast( child ).pojoType );
		return false;
	}

	@Override
	public boolean isAssignableFrom(IndexedEntityTypeIdentifier currentClass) {
		//FIXME implement me
		return false;
	}

	@Override
	public IndexedEntityTypeIdentifier getSuperclass() {
		//FIXME implement me
		return null;
	}

	@Override
	public Iterable<IndexedEntityTypeIdentifier> getInterfaces() {
		//FIXME implement me
		return null;
	}

	private PojoEntityTypeIdentifier cast(IndexedEntityTypeIdentifier typeId) {
		try {
			return (PojoEntityTypeIdentifier) typeId;
		}
		catch (ClassCastException cce) {
			throw log.incompatibleIndexTypeIdentifier( typeId.getClass(), PojoEntityTypeIdentifier.class );
		}
	}


}
