/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.spi;

/**
 * To be renamed to TypeIdentifier 
 */
public interface IndexedEntityTypeIdentifier {

	/**
	 * @see Class#getName()
	 */
	String getName();

	/**
	 * TODO Move to Type medatadata source
	 */
	boolean isParentTypeOf(IndexedEntityTypeIdentifier child);

	/**
	 * @see Class#getSuperclass()
	 */
	boolean isAssignableFrom(IndexedEntityTypeIdentifier currentClass);

	/**
	 * Return the parent type, or null if there is no parent type.
	 * For exact semantics as defined on Java class types,
	 * see {@link Class#getSuperclass()}
	 */
	IndexedEntityTypeIdentifier getSuperclass();

	/**
	 * @see Class#getInterfaces()
	 */
	Iterable<IndexedEntityTypeIdentifier> getInterfaces();

}
