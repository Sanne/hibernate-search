/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.spi.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.search.spi.IndexedTypeIdentifier;
import org.hibernate.search.spi.IndexedTypesSet;

public final class IndexedTypesSets {

	private IndexedTypesSets() {
		//Utility class: not to be constructed
	}

	public static IndexedTypesSet fromClasses(Class<?>... classes) {
		if ( classes == null || classes.length == 0 ) {
			// "null" needs to be acceptable to support some legacy use cases
			return empty();
		}
		else if ( classes.length == 1 ) {
			return fromClass( classes[0] );
		}
		else {
			HashSet<IndexedTypeIdentifier> set = new HashSet<>();
			for ( Class<?> c : classes ) {
				set.add( new PojoIndexedTypeIdentifier( c ) );
			}
			return new HashSetIndexedTypesSet( set );
		}
	}

	public static IndexedTypesSet fromClass(Class clazz) {
		Objects.requireNonNull( clazz );
		return fromIdentifier( new PojoIndexedTypeIdentifier( clazz ) );
	}

	public static IndexedTypesSet fromIdentifier(IndexedTypeIdentifier type) {
		Objects.requireNonNull( type );
		return new HashSetIndexedTypesSet( Collections.singleton( type ) );
	}

	public static IndexedTypesSet empty() {
		return HashSetIndexedTypesSet.EMPTY;
	}

	public static IndexedTypesSet fromIdentifiers(Collection<IndexedTypeIdentifier> entityTypes) {
		Objects.requireNonNull( entityTypes );
		if ( entityTypes instanceof Set<?> ) {
			return new HashSetIndexedTypesSet( (Set<IndexedTypeIdentifier>) entityTypes );
		}
		HashSet<IndexedTypeIdentifier> set = new HashSet<>();
		for ( IndexedTypeIdentifier iti : entityTypes ) {
			set.add( iti );
		}
		return new HashSetIndexedTypesSet( set );
	}

	public static IndexedTypesSet fromIdentifiers(IndexedTypeIdentifier... types) {
		if ( types == null || types.length == 0 ) {
			// "null" needs to be acceptable to support some legacy use cases
			return empty();
		}
		else if ( types.length == 1 ) {
			return fromIdentifier( types[0] );
		}
		else {
			HashSet<IndexedTypeIdentifier> set = new HashSet<>();
			for ( IndexedTypeIdentifier c : types ) {
				set.add( c );
			}
			return new HashSetIndexedTypesSet( set );
		}
	}

}
