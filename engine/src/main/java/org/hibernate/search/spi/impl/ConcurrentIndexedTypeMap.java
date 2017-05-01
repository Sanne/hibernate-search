/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.spi.impl;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.search.spi.IndexedTypeIdentifier;
import org.hibernate.search.spi.IndexedTypeMap;
import org.hibernate.search.spi.IndexedTypesSet;

public class ConcurrentIndexedTypeMap<V> implements IndexedTypeMap<V> {

	private final ConcurrentHashMap<IndexedTypeIdentifier,V> map = new ConcurrentHashMap<>();

	@Override
	public V get(IndexedTypeIdentifier key) {
		return map.get( key );
	}

	@Override
	public Iterable<Entry<IndexedTypeIdentifier, V>> entrySet() {
		return map.entrySet();
	}

	@Override
	public V get(Class<?> legacyPojo) {
		return map.get( new PojoIndexedTypeIdentifier( legacyPojo ) );
	}

	@Override
	public IndexedTypesSet keySet() {
		return IndexedTypesSets.fromIdentifiers( map.keySet() );
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public boolean containsKey(IndexedTypeIdentifier type) {
		return map.containsKey( type );
	}

	@Override
	public boolean containsKey(Class<?> legacyPojo) {
		return map.containsKey( new PojoIndexedTypeIdentifier( legacyPojo ) );
	}

	@Override
	public void put(IndexedTypeIdentifier type, V value) {
		map.put( type, value );
	}

	@Override
	public void put(Class<?> type, V typeBinding) {
		put( new PojoIndexedTypeIdentifier( type ), typeBinding );
	}

}
