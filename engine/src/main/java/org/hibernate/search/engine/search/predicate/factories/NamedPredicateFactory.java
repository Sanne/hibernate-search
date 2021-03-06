/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.engine.search.predicate.factories;

import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;

/**
 * A factory for predicates, which is given a name and assigned to an element in the index schema.
 * <p>
 * This factory takes advantage of provided metadata
 * to pick, configure and create a {@link SearchPredicate}.
 *
 * @see SearchPredicate
 *
 */
public interface NamedPredicateFactory {

	/**
	 * Creates a named predicate.
	 * @param ctx The context, exposing in particular a {@link SearchPredicateFactory}.
	 * @return The created {@link SearchPredicate}.
	 */
	SearchPredicate create(NamedPredicateFactoryContext ctx);

}
