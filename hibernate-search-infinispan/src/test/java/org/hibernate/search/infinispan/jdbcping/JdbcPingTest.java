/* 
 * Hibernate, Relational Persistence for Idiomatic Java
 * 
 * JBoss, Home of Professional Open Source
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.hibernate.search.infinispan.jdbcping;

import org.hibernate.cfg.Environment;
import org.hibernate.search.infinispan.CacheManagerServiceProvider;
import org.hibernate.search.infinispan.LiveRunningTest;
import org.hibernate.search.test.util.FullTextSessionBuilder;


/**
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2012 Red Hat Inc.
 */
public class JdbcPingTest extends LiveRunningTest {

	@Override
	protected FullTextSessionBuilder createClusterNode() {
		FullTextSessionBuilder node = new FullTextSessionBuilder()
		.setProperty( "hibernate.search.default.directory_provider", "infinispan" )
		// this schema is shared across nodes, so don't drop it on shutdown:
		.setProperty( Environment.HBM2DDL_AUTO, "create" )
		// share the same in-memory database connection pool
		.setProperty(
				Environment.CONNECTION_PROVIDER,
				org.hibernate.search.infinispan.ClusterSharedConnectionProvider.class.getName()
				)
		.setProperty( CacheManagerServiceProvider.INFINISPAN_CONFIGURATION_RESOURCENAME, "test-jdbc_ping/infinispan-jdbc_ping.xml" );
		for ( Class<?> entityType : entityTypes ) {
			node.addAnnotatedClass( entityType );
		}
		return node.build();
	}

}
