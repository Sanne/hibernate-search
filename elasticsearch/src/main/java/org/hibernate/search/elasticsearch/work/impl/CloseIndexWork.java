/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.elasticsearch.work.impl;

import org.elasticsearch.client.Response;
import org.hibernate.search.elasticsearch.client.impl.ElasticsearchRequest;
import org.hibernate.search.elasticsearch.client.impl.PathComponent;
import org.hibernate.search.elasticsearch.work.impl.builder.CloseIndexWorkBuilder;

import com.google.gson.JsonObject;

public class CloseIndexWork extends SimpleElasticsearchWork<Void> {

	private static final PathComponent CLOSE_PATH = PathComponent.fromString( "_close" );

	protected CloseIndexWork(Builder builder) {
		super( builder );
	}

	@Override
	protected Void generateResult(ElasticsearchWorkExecutionContext context, Response response, JsonObject parsedResponseBody) {
		return null;
	}

	public static class Builder
			extends SimpleElasticsearchWork.Builder<Builder>
			implements CloseIndexWorkBuilder {

		private final PathComponent indexName;

		public Builder(PathComponent indexName) {
			super( null, DefaultElasticsearchRequestSuccessAssessor.INSTANCE );
			this.indexName = indexName;
		}

		@Override
		protected ElasticsearchRequest buildRequest() {
			ElasticsearchRequest.Builder builder =
					ElasticsearchRequest.post()
					.pathComponent( indexName )
					.pathComponent( CLOSE_PATH );

			return builder.build();
		}

		@Override
		public CloseIndexWork build() {
			return new CloseIndexWork( this );
		}
	}
}