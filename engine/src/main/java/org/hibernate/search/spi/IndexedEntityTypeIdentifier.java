package org.hibernate.search.spi;

/**
 * To be renamed to TypeIdentifier 
 */
public interface IndexedEntityTypeIdentifier {

	String getName();

	/**
	 * Move to Type medatadata source
	 */
	boolean isParentTypeOf( IndexedEntityTypeIdentifier child );

	boolean isAssignableFrom(IndexedEntityTypeIdentifier currentClass);

	IndexedEntityTypeIdentifier getSuperclass();

	Iterable<IndexedEntityTypeIdentifier> getInterfaces();

}
