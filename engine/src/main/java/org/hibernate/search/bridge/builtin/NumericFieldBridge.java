/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.bridge.builtin;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.hibernate.search.bridge.FieldBridge;
import org.hibernate.search.bridge.LuceneOptions;
import org.hibernate.search.bridge.TwoWayFieldBridge;
import org.hibernate.search.bridge.impl.NullEncodingCapable;
import org.hibernate.search.bridge.impl.NullEncodingIgnoring;
import org.hibernate.search.util.logging.impl.Log;
import org.hibernate.search.util.logging.impl.LoggerFactory;

/**
 * Stateless field bridges for the conversion of numbers to numeric field values.
 *
 * @author Sanne Grinovero
 * @author Gunnar Morling
 */
public enum NumericFieldBridge implements FieldBridge, TwoWayFieldBridge, NullEncodingCapable, NullEncodingIgnoring {

	/**
	 * Persists byte properties in int index fields. Takes care of all the required conversion.
	 */
	BYTE_FIELD_BRIDGE {
		@Override
		public Object get(final String name, final Document document) {
			final IndexableField field = document.getField( name );
			return field != null ? field.numericValue().byteValue() : null;
		}

		@Override
		protected void applyToLuceneOptions(LuceneOptions luceneOptions, String name, Number value, Document document) {
			super.applyToLuceneOptions( luceneOptions, name, value.intValue(), document );
		}

		@Override
		public Query generateUniverseRangeQuery(String fieldName) {
			return NumericRangeQuery.newIntRange( fieldName, null, null, true, true );
		}

		@Override
		public void warnForIgnoringNullEncodingRequest(String fieldName, String entityName) {
			log.ignoringNullTokenMappingForByteEncodedField( fieldName, entityName );
		}
	},
	/**
	 * Persists short properties in int index fields. Takes care of all the required conversion.
	 */
	SHORT_FIELD_BRIDGE {
		@Override
		public Object get(final String name, final Document document) {
			final IndexableField field = document.getField( name );
			return field != null ? field.numericValue().shortValue() : null;
		}

		@Override
		protected void applyToLuceneOptions(LuceneOptions luceneOptions, String name, Number value, Document document) {
			super.applyToLuceneOptions( luceneOptions, name, value.intValue(), document );
		}

		@Override
		public Query generateUniverseRangeQuery(String fieldName) {
			return NumericRangeQuery.newIntRange( fieldName, null, null, true, true );
		}

		@Override
		public void warnForIgnoringNullEncodingRequest(String fieldName, String entityName) {
			log.ignoringNullTokenMappingForShortEncodedField( fieldName, entityName );
		}
	},
	/**
	 * Persists int properties in int index fields. Takes care of all the required conversion.
	 */
	INT_FIELD_BRIDGE {

		@Override
		public Query generateUniverseRangeQuery(String fieldName) {
			return NumericRangeQuery.newIntRange( fieldName, null, null, true, true );
		}

		@Override
		public void warnForIgnoringNullEncodingRequest(String fieldName, String entityName) {
			log.ignoringNullTokenMappingForIntegerEncodedField( fieldName, entityName );
		}

	},
	/**
	 * Persists float properties in float index fields. Takes care of all the required conversion.
	 */
	FLOAT_FIELD_BRIDGE {

		@Override
		public Query generateUniverseRangeQuery(String fieldName) {
			return NumericRangeQuery.newFloatRange( fieldName, null, null, true, true );
		}

		@Override
		public void warnForIgnoringNullEncodingRequest(String fieldName, String entityName) {
			log.ignoringNullTokenMappingForFloatEncodedField( fieldName, entityName );
		}

	},
	/**
	 * Persists double properties in double index fields. Takes care of all the required conversion.
	 */
	DOUBLE_FIELD_BRIDGE {

		@Override
		public Query generateUniverseRangeQuery(String fieldName) {
			return NumericRangeQuery.newDoubleRange( fieldName, null, null, true, true );
		}

		@Override
		public void warnForIgnoringNullEncodingRequest(String fieldName, String entityName) {
			log.ignoringNullTokenMappingForDoubleEncodedField( fieldName, entityName );
		}

	},
	/**
	 * Persists long properties in long index fields. Takes care of all the required conversion.
	 */
	LONG_FIELD_BRIDGE {

		@Override
		public Query generateUniverseRangeQuery(String fieldName) {
			return NumericRangeQuery.newLongRange( fieldName, null, null, true, true );
		}

		@Override
		public void warnForIgnoringNullEncodingRequest(String fieldName, String entityName) {
			log.ignoringNullTokenMappingForLongEncodedField( fieldName, entityName );
		}

	};

	@Override
	public void set(String name, Object value, Document document, LuceneOptions luceneOptions) {
		if ( value != null ) {
			applyToLuceneOptions( luceneOptions, name, (Number)value, document );
		}
		// Else: for null values no field is encoded for numeric fields, or it breaks sorting.
		// See also HSEARCH-1956
	}

	@Override
	public final String objectToString(final Object object) {
		return object == null ? null : object.toString();
	}

	@Override
	public Object get(final String name, final Document document) {
		final IndexableField field = document.getField( name );
		if ( field != null ) {
			return field.numericValue();
		}
		else {
			return null;
		}
	}

	protected void applyToLuceneOptions(LuceneOptions luceneOptions, String name, Number value, Document document) {
		luceneOptions.addNumericFieldToDocument( name, value, document );
	}

	public abstract Query generateUniverseRangeQuery(String fieldName);

	private static final Log log = LoggerFactory.make();

}
