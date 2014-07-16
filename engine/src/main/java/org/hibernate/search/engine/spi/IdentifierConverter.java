/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.engine.spi;

import org.hibernate.search.spi.IndexedEntityTypeIdentifier;

public interface IdentifierConverter<T> {

	IndexedEntityTypeIdentifier convertEntityIdentifier(T entityClass);

	/*
	 * Class<?> entityClass = org.hibernate.search.util.impl.ClassLoaderHelper.classForName(
				entityClassName,
				"entity class",
				searchFactory.getServiceManager()
		);
	 */
	IndexedEntityTypeIdentifier fromName(String entityClassName);

	T inverseConversion(IndexedEntityTypeIdentifier key);

}
