/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.util.logging.impl;

import org.hibernate.search.spi.IndexedEntityTypeIdentifier;

public class TypeFormatter {

	private final IndexedEntityTypeIdentifier type;

	public TypeFormatter(IndexedEntityTypeIdentifier type) {
		this.type = type;
	}

	@Override
	public String toString() {
		//TODO see if we want to customize, and if we should use a converter at all
		return String.valueOf( type );
	}

}
