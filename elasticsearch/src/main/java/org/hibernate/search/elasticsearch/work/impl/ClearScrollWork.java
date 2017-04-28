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
import org.hibernate.search.elasticsearch.impl.JsonBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.ClearScrollWorkBuilder;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * @author Yoann Rodiere
 */
public class ClearScrollWork extends SimpleElasticsearchWork<Void> {

	private static final PathComponent SEARCH_PATH = PathComponent.fromString( "_search" );
	private static final PathComponent SCROLL_PATH = PathComponent.fromString( "scroll" );

	protected ClearScrollWork(Builder builder) {
		super( builder );
	}

	@Override
	protected Void generateResult(ElasticsearchWorkExecutionContext context, Response response, JsonObject parsedResponseBody) {
		return null;
	}

	public static class Builder
			extends SimpleElasticsearchWork.Builder<Builder>
			implements ClearScrollWorkBuilder {
		private final String scrollId;

		public Builder(String scrollId) {
			super( null, DefaultElasticsearchRequestSuccessAssessor.INSTANCE );
			this.scrollId = scrollId;
		}

		@Override
		protected ElasticsearchRequest buildRequest() {
			ElasticsearchRequest.Builder builder =
					ElasticsearchRequest.delete()
					.pathComponent( SEARCH_PATH )
					.pathComponent( SCROLL_PATH )
					.body(JsonBuilder.object()
							.add( "scroll_id", JsonBuilder.array().add( new JsonPrimitive( scrollId ) ) )
							.build()
					);

			return builder.build();
		}

		@Override
		public ClearScrollWork build() {
			return new ClearScrollWork( this );
		}
	}
}