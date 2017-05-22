/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.spi.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;

import org.hibernate.search.spi.IndexedTypeIdentifier;
import org.hibernate.search.spi.IndexedTypesSet;
import org.hibernate.search.util.logging.impl.Log;
import org.hibernate.search.util.logging.impl.LoggerFactory;

/**
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2017 Red Hat Inc.
 */
public final class PojoIndexedTypeIdentifier implements IndexedTypeIdentifier, Serializable {

	private static final Log log = LoggerFactory.make();

	private final Class<?> pojoType;

	public PojoIndexedTypeIdentifier(Class<?> pojoType) {
		Objects.requireNonNull( pojoType );
		this.pojoType = pojoType;
	}

	@Override
	public String getName() {
		return pojoType.getName();
	}

	@Override
	public Class<?> getPojoType() {
		return pojoType;
	}

	@Override
	public IndexedTypesSet asTypeSet() {
		return new HashSetIndexedTypesSet( Collections.singleton( this ) );
	}

	@Override
	public int hashCode() {
		return pojoType.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if ( this == obj ) {
			return true;
		}
		else if ( obj == null ) {
			return false;
		}
		else {
			//Be paranoid about type matching: converting among types on Map isn't entirely typesafe as Map#get, remove, etc.. accept Object rather than
			//restricting to the generic type of the Map.
			//This new "type system" is designed having in mind that only one type model will be used, so no mixed implementations of IndexedTypeIdentifier
			//are allowed.
			//We prefer a ClassCastException here over "return false" to spot any mistakes aggressively.
			assert PojoIndexedTypeIdentifier.class == obj.getClass() : "This should never happen. If it happens, you're mixing types in the same Map and that's a bug";
			PojoIndexedTypeIdentifier other = (PojoIndexedTypeIdentifier) obj;
			return pojoType.equals( other.pojoType );
		}
	}

	@Override
	public String toString() {
		return getName();
	}

}
