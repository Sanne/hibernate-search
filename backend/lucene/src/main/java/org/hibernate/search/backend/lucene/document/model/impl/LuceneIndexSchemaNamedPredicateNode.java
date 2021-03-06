/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.lucene.document.model.impl;

import org.hibernate.search.engine.search.predicate.factories.NamedPredicateFactory;

public class LuceneIndexSchemaNamedPredicateNode {

	private final LuceneIndexSchemaObjectNode parent;
	private final String relativeNamedPredicateName;
	private final String absoluteNamedPredicatePath;

	private final NamedPredicateFactory factory;

	public LuceneIndexSchemaNamedPredicateNode(LuceneIndexSchemaObjectNode parent,
			String relativeNamedPredicateName,
			NamedPredicateFactory factory) {
		this.parent = parent;
		this.relativeNamedPredicateName = relativeNamedPredicateName;
		this.absoluteNamedPredicatePath = parent.absolutePath( relativeNamedPredicateName );
		this.factory = factory;
	}

	public LuceneIndexSchemaObjectNode parent() {
		return parent;
	}

	public String absoluteNamedPredicatePath() {
		return absoluteNamedPredicatePath;
	}

	public NamedPredicateFactory factory() {
		return factory;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[" + "parent=" + parent + ", relativeFieldName=" + relativeNamedPredicateName + "]";
	}

}
