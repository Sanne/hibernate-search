/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.engine.search.predicate.dsl;

/**
 * The initial step in a "phrase" predicate definition, where the target field can be set.
 *
 * @param <N> The type of the next step.
 */
public interface PhrasePredicateFieldStep<N extends PhrasePredicateFieldMoreStep<?, ?>> {

	/**
	 * Target the given field in the phrase predicate.
	 * <p>
	 * Only text fields are supported.
	 * <p>
	 * Multiple fields may be targeted by the same predicate:
	 * the predicate will match if <em>any</em> targeted field matches.
	 * <p>
	 * When targeting multiple fields, those fields must have compatible types.
	 * Please refer to the reference documentation for more information.
	 *
	 * @param absoluteFieldPath The absolute path (from the document root) of the targeted field.
	 * @return The next step.
	 */
	default N field(String absoluteFieldPath) {
		return fields( absoluteFieldPath );
	}

	/**
	 * Target the given fields in the phrase predicate.
	 * <p>
	 * Only text fields are supported.
	 * <p>
	 * Equivalent to {@link #field(String)} followed by multiple calls to
	 * {@link PhrasePredicateFieldMoreStep#field(String)},
	 * the only difference being that calls to {@link PhrasePredicateFieldMoreStep#boost(float)}
	 * and other field-specific settings on the returned step will only need to be done once
	 * and will apply to all the fields passed to this method.
	 *
	 * @param absoluteFieldPaths The absolute paths (from the document root) of the targeted fields.
	 * @return The next step.
	 *
	 * @see #field(String)
	 */
	N fields(String... absoluteFieldPaths);

}
