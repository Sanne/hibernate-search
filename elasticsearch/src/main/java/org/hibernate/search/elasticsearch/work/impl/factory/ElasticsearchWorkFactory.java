/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.elasticsearch.work.impl.factory;

import java.util.List;

import org.hibernate.search.elasticsearch.cfg.ElasticsearchIndexStatus;
import org.hibernate.search.elasticsearch.client.impl.PathComponent;
import org.hibernate.search.elasticsearch.schema.impl.model.TypeMapping;
import org.hibernate.search.elasticsearch.settings.impl.model.IndexSettings;
import org.hibernate.search.elasticsearch.work.impl.BulkableElasticsearchWork;
import org.hibernate.search.elasticsearch.work.impl.builder.BulkWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.ClearScrollWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.CloseIndexWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.CreateIndexWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.DeleteByQueryWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.DeleteWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.DropIndexWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.ExplainWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.FlushWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.GetIndexTypeMappingsWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.GetIndexSettingsWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.IndexExistsWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.IndexWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.OpenIndexWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.OptimizeWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.PutIndexMappingWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.PutIndexSettingsWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.RefreshWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.ScrollWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.SearchWorkBuilder;
import org.hibernate.search.elasticsearch.work.impl.builder.WaitForIndexStatusWorkBuilder;

import com.google.gson.JsonObject;

/**
 * @author Yoann Rodiere
 */
public interface ElasticsearchWorkFactory {

	IndexWorkBuilder index(PathComponent indexName, String typeName, String id, JsonObject document);

	DeleteWorkBuilder delete(PathComponent indexName, String typeName, String id);

	DeleteByQueryWorkBuilder deleteByQuery(PathComponent indexName, JsonObject payload);

	FlushWorkBuilder flush();

	RefreshWorkBuilder refresh();

	OptimizeWorkBuilder optimize();

	BulkWorkBuilder bulk(List<BulkableElasticsearchWork<?>> bulkableWorks);

	SearchWorkBuilder search(JsonObject payload);

	ExplainWorkBuilder explain(PathComponent indexName, String typeName, String id, JsonObject payload);

	ScrollWorkBuilder scroll(String scrollId, String scrollTimeout);

	ClearScrollWorkBuilder clearScroll(String scrollId);

	CreateIndexWorkBuilder createIndex(PathComponent indexName);

	DropIndexWorkBuilder dropIndex(PathComponent indexName);

	OpenIndexWorkBuilder openIndex(PathComponent indexName);

	CloseIndexWorkBuilder closeIndex(PathComponent indexName);

	IndexExistsWorkBuilder indexExists(PathComponent indexName);

	GetIndexSettingsWorkBuilder getIndexSettings(PathComponent indexName);

	PutIndexSettingsWorkBuilder putIndexSettings(PathComponent indexName, IndexSettings settings);

	GetIndexTypeMappingsWorkBuilder getIndexTypeMappings(PathComponent indexName);

	PutIndexMappingWorkBuilder putIndexTypeMapping(PathComponent indexName, String typeName, TypeMapping mapping);

	WaitForIndexStatusWorkBuilder waitForIndexStatusWork(PathComponent indexName, ElasticsearchIndexStatus requiredStatus, String timeout);

}
