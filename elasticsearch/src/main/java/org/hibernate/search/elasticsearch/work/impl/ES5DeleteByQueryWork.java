/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.elasticsearch.work.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.client.Response;
import org.hibernate.search.elasticsearch.client.impl.ElasticsearchRequest;
import org.hibernate.search.elasticsearch.client.impl.PathComponent;
import org.hibernate.search.elasticsearch.work.impl.builder.DeleteByQueryWorkBuilder;

import com.google.gson.JsonObject;

/**
 * A delete by query work for ES5, using the core delete-by-query API.
 *
 * @author Yoann Rodiere
 */
public class ES5DeleteByQueryWork extends SimpleElasticsearchWork<Void> {

	protected ES5DeleteByQueryWork(Builder builder) {
		super( builder );
	}

	@Override
	protected Void generateResult(ElasticsearchWorkExecutionContext context, Response response, JsonObject parsedResponseBody) {
		return null;
	}

	public static class Builder
			extends SimpleElasticsearchWork.Builder<Builder>
			implements DeleteByQueryWorkBuilder {
		private final PathComponent indexName;
		private final JsonObject payload;
		private List<String> typeNames = new ArrayList<>();

		public Builder(PathComponent indexName, JsonObject payload) {
			super( indexName, DefaultElasticsearchRequestSuccessAssessor.INSTANCE );
			this.indexName = indexName;
			this.payload = payload;
		}

		@Override
		public Builder type(String typeName) {
			typeNames.add( typeName );
			return this;
		}

		@Override
		protected ElasticsearchRequest buildRequest() {
			ElasticsearchRequest.Builder builder =
					ElasticsearchRequest.post()
					.pathComponent( indexName );

			if ( !typeNames.isEmpty() ) {
				builder.multiValuedPathComponent( typeNames );
			}

			builder.pathComponent( "_delete_by_query" )
					.body( payload );

			return builder.build();
		}

		@Override
		public ES5DeleteByQueryWork build() {
			return new ES5DeleteByQueryWork( this );
		}
	}
}