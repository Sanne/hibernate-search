/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.elasticsearch.gson.impl;

import java.util.Optional;
import java.util.function.Supplier;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

/**
 * An interface that abstracts the ways of accessing values in a JSON tree.
 *
 * @see #root()
 * @see JsonObjectAccessor
 * @see JsonArrayAccessor
 * @see UnknownTypeJsonAccessor
 *
 */
public interface JsonAccessor<T> {

	/**
	 * Get the current value of the element this accessor points to for the given {@code root}.
	 *
	 * @param root The root to be accessed.
	 * @return An {@link java.util.Optional} containing the current value pointed to by this accessor on the {@code root},
	 * or {@link java.util.Optional#empty()} if it doesn't exist.
	 * @throws UnexpectedJsonElementTypeException If an element in the path has unexpected type,
	 * preventing access to the element this accessor points to.
	 */
	Optional<T> get(JsonObject root);

	/**
	 * Detects whether the element this accessor points to for the given {@code root} has an explicit value.
	 * <p>
	 * This method is slightly different from {@code get(root).isPresent()} in that it will return true
	 * if the current value is {@link JsonNull#INSTANCE}, as it is considered as an explicit value.
	 * Also, it will work fine if the leaf value has the wrong type (array of objects instead of object, for example).
	 *
	 * @param root The root to be accessed.
	 * @return {@code true} if there is an explicit value (be it {@link JsonNull#INSTANCE} or a non-null value),
	 * {@code false} otherwise.
	 * @throws UnexpectedJsonElementTypeException If an element in the path has unexpected type,
	 * preventing access to the element this accessor points to.
	 */
	boolean hasExplicitValue(JsonObject root);

	/**
	 * Set the given value on the element this accessor points to for the given {@code root}.
	 *
	 * @param root The root to be accessed.
	 * @param newValue The value to set.
	 * @throws UnexpectedJsonElementTypeException If an element in the path has unexpected type, preventing
	 * access to the element this accessor points to.
	 */
	void set(JsonObject root, T newValue);

	/**
	 * Add the given primitive value to the element this accessor points to for the
	 * given {@code root}.
	 *
	 * <p>This method differs from {@link #set(JsonObject, Object)}:
	 * <ul>
	 * <li>If there is currently no value, the given value is simply
	 * {@link #set(JsonObject, Object) set}.
	 * <li>If the current value is an array, the given value is added to this array.
	 * <li>If the current value is a primitive or {@link JsonNull}, the current value
	 * is replaced by an array containing the current value followed by the given value.
	 * <li>Otherwise (i.e. if the current value is an object), an
	 * {@link UnexpectedJsonElementTypeException} is thrown.
	 * </ul>
	 *
	 * @param root The root to be accessed.
	 * @param newValue The value to add.
	 * @throws UnexpectedJsonElementTypeException If an element in the path has unexpected type, preventing
	 * write access to the element this accessor points to.
	 */
	void add(JsonObject root, T newValue);

	/**
	 * Get the current value of the element this accessor points to for the given {@code root},
	 * creating it and setting it if it hasn't been set yet.
	 *
	 * @param root The root to be accessed.
	 * @param newValueSupplier The value to set and return if the current value hasn't been set yet.
	 * @return The current value pointed to by this accessor on the {@code root}, always non-null.
	 * @throws UnexpectedJsonElementTypeException if the element already exists and is not of the expected type,
	 * or if an element in the path has unexpected type, preventing access to the element this accessor
	 * points to.
	 */
	T getOrCreate(JsonObject root, Supplier<? extends T> newValueSupplier);

	static JsonObjectAccessor root() {
		return RootJsonAccessor.INSTANCE;
	}

}
