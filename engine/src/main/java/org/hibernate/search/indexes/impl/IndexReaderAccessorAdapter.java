/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.indexes.impl;

import org.apache.lucene.index.IndexReader;
import org.hibernate.search.engine.spi.IdentifierConverter;
import org.hibernate.search.indexes.IndexReaderAccessor;
import org.hibernate.search.indexes.spi.EntityIndexReaderAccessor;
import org.hibernate.search.spi.IndexedEntityTypeIdentifier;

public class IndexReaderAccessorAdapter implements IndexReaderAccessor {

	private final EntityIndexReaderAccessor indexReaderAccessor;
	private IdentifierConverter identifierConverter;

	public IndexReaderAccessorAdapter(EntityIndexReaderAccessor indexReaderAccessor, IdentifierConverter identifierConverter) {
		this.indexReaderAccessor = indexReaderAccessor;
		this.identifierConverter = identifierConverter;
	}

	@Override
	public IndexReader open(Class<?>... entities) {
		IndexedEntityTypeIdentifier[] converted = new IndexedEntityTypeIdentifier[entities.length];
		for (int i = 0; i < converted.length; i++) {
			converted[i] = identifierConverter.convertEntityIdentifier( entities[i] ); 
		}
		return indexReaderAccessor.open( converted );
	}

	@Override
	public IndexReader open(String... indexNames) {
		return indexReaderAccessor.open( indexNames );
	}

	@Override
	public void close(IndexReader indexReader) {
		indexReaderAccessor.close( indexReader );
	}

}
