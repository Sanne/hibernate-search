/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.util.impl.integrationtest.common.stub.backend.types.impl;

import java.util.List;
import java.util.function.Consumer;

import org.hibernate.search.engine.backend.types.IndexFieldType;
import org.hibernate.search.util.impl.integrationtest.common.stub.backend.document.model.StubIndexSchemaNode;

public final class StubIndexFieldType<F> implements IndexFieldType<F> {
	private final Class<F> inputType;
	private final List<Consumer<StubIndexSchemaNode.Builder>> modifiers;

	public StubIndexFieldType(Class<F> inputType, List<Consumer<StubIndexSchemaNode.Builder>> modifiers) {
		this.inputType = inputType;
		this.modifiers = modifiers;
	}

	public void addField(StubIndexSchemaNode.Builder builder) {
		builder.inputType( inputType );
		for ( Consumer<StubIndexSchemaNode.Builder> modifier : modifiers ) {
			modifier.accept( builder );
		}
	}
}
