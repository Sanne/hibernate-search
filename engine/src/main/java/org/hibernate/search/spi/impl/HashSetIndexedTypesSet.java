/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.spi.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.search.spi.IndexedTypeIdentifier;
import org.hibernate.search.spi.IndexedTypesSet;

final class HashSetIndexedTypesSet implements IndexedTypesSet, Serializable {

	public static final IndexedTypesSet EMPTY = new HashSetIndexedTypesSet( Collections.EMPTY_SET );

	private final Set<IndexedTypeIdentifier> set;

	HashSetIndexedTypesSet(Set<IndexedTypeIdentifier> set) {
		Objects.requireNonNull( set );
		this.set = set;
	}

	@Override
	public Iterator<IndexedTypeIdentifier> iterator() {
		return set.iterator();
	}

	@Override
	public int size() {
		return set.size();
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	@Override
	@Deprecated
	public Set<Class<?>> toPojosSet() {
		return set.stream().map( IndexedTypeIdentifier::getPojoType ).collect( Collectors.toSet() );
	}

	boolean contains(IndexedTypeIdentifier id) {
		return set.contains( id );
	}

	Set<IndexedTypeIdentifier> cloneMap() {
		return new HashSet( set );
	}

	@Override
	public String toString() {
		return set.toString();
	}

	@Override
	public int hashCode() {
		return set.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if ( this == obj ) {
			return true;
		}
		else if ( obj == null ) {
			return false;
		}
		else if ( HashSetIndexedTypesSet.class != obj.getClass() ) {
				return false;
		}
		else {
			HashSetIndexedTypesSet other = (HashSetIndexedTypesSet) obj;
			return set.equals( other.set );
		}
	}

	@Override
	public boolean containsAll(IndexedTypesSet subsetCandidate) {
		for ( IndexedTypeIdentifier e : subsetCandidate ) {
			if ( ! set.contains( e ) ) {
				return false;
			}
		}
		return true;
	}

}
