/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.lucene.search.impl;

import java.util.Map;

/**
 * Information about a composite index element targeted by search; either the index root or an object field.
 * <p>
 * For now this is only used in predicates.
 */
public interface LuceneSearchCompositeIndexSchemaElementContext extends LuceneSearchIndexSchemaElementContext {

	String absolutePath(String relativeFieldName);

	Map<String, ? extends LuceneSearchIndexSchemaElementContext> staticChildrenByName();

	boolean nested();

	<T> LuceneSearchCompositeIndexSchemaElementQueryElementFactory<T> queryElementFactory(SearchQueryElementTypeKey<T> key);

}