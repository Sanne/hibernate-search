/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.spi;

import java.util.Map.Entry;

/**
 * This represents a Map but exposes a more restricted set of operations,
 * allowing us to better encapsulate the contract and perform some optimisations.
 *
 * Also improves type-safety as it enforces usage of IndexedTypeIdentifier as keys,
 * something the standard Map contract doesn't help with.
 *
 * @author Sanne Grinovero
 */
public interface IndexedTypeMap<V> {

	V get(IndexedTypeIdentifier key);

	Iterable<Entry<IndexedTypeIdentifier, V>> entrySet();

	/**
	 * @return
	 */
	IndexedTypesSet keySet();

	/**
	 * @return
	 */
	int size();

	/**
	 * @return
	 */
	boolean isEmpty();

	/**
	 * @return
	 */
	Iterable<V> values();

	/**
	 * @param pojoIndexedTypeIdentifier
	 * @return
	 */
	boolean containsKey(IndexedTypeIdentifier type);

	void put(IndexedTypeIdentifier type, V typeBinding);

	/**
	 * @deprecated use {@link #get(IndexedTypeIdentifier)}. This method will be removed.
	 * @param legacyPojo the Class whose type is to be used as a key.
	 * @return the value mapped to this key.
	 */
	@Deprecated
	V get(Class<?> legacyPojo);


	/**
	 * @param entity
	 * @return
	 */
	@Deprecated
	boolean containsKey(Class<?> entity);

	@Deprecated
	void put(Class<?> type, V typeBinding);

}
