/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

package org.hibernate.search.spi.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.search.spi.IndexedEntityTypeIdentifier;
import org.hibernate.search.util.logging.impl.Log;
import org.hibernate.search.util.logging.impl.LoggerFactory;

/**
 * Helper class which keeps track of all super classes and interfaces of the indexed entities.
 */
//FIXME make it immutable (builder pattern)
public class PolymorphicIndexHierarchy {
	private static final Log log = LoggerFactory.make();

	private Map<IndexedEntityTypeIdentifier, Set<IndexedEntityTypeIdentifier>> classToIndexedClass;

	public PolymorphicIndexHierarchy() {
		classToIndexedClass = new HashMap<IndexedEntityTypeIdentifier, Set<IndexedEntityTypeIdentifier>>();
	}

	public void addIndexedClass(IndexedEntityTypeIdentifier indexedClass) {
		addClass( indexedClass, indexedClass );
		IndexedEntityTypeIdentifier superClass = indexedClass.getSuperclass();
		while ( superClass != null ) {
			addClass( superClass, indexedClass );
			superClass = superClass.getSuperclass();
		}
		for ( IndexedEntityTypeIdentifier clazz : indexedClass.getInterfaces() ) {
			addClass( clazz, indexedClass );
		}
	}

	private void addClass(IndexedEntityTypeIdentifier superclass, IndexedEntityTypeIdentifier indexedClass) {
		Set<IndexedEntityTypeIdentifier> classesSet = classToIndexedClass.get( superclass );
		if ( classesSet == null ) {
			classesSet = new HashSet<IndexedEntityTypeIdentifier>();
			classToIndexedClass.put( superclass, classesSet );
		}
		classesSet.add( indexedClass );
	}

	public Set<IndexedEntityTypeIdentifier> getIndexedClasses(IndexedEntityTypeIdentifier[] classes) {
		Set<IndexedEntityTypeIdentifier> indexedClasses = new HashSet<IndexedEntityTypeIdentifier>();
		for ( IndexedEntityTypeIdentifier clazz : classes ) {
			Set<IndexedEntityTypeIdentifier> set = classToIndexedClass.get( clazz );
			if ( set != null ) {
				// at this point we don't have to care about including indexed subclasses of a indexed class
				// MultiClassesQueryLoader will take care of this later and optimise the queries
				indexedClasses.addAll( set );
			}
		}
		if ( log.isTraceEnabled() ) {
			log.tracef( "Targeted indexed classes for %s: %s", Arrays.toString( classes ), indexedClasses );
		}
		return indexedClasses;
	}
}
