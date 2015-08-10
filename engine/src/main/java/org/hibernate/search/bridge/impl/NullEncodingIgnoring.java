/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.bridge.impl;

/**
 * Marker interface to indicate that a StringBridge or FieldBridge implementation
 * will ignore the attribute {@literal indexNullAs} of annotation {@link org.hibernate.search.annotations.Field}
 * if it's set to anything different than {@literal DO_NOT_INDEX_NULL}.
 * This should cause a warning or an exception.
 */
public interface NullEncodingIgnoring {

	void warnForIgnoringNullEncodingRequest(String fieldName, String entityName);

}
