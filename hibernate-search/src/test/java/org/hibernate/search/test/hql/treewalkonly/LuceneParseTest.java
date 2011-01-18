/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2011, Red Hat, Inc. and/or its affiliates or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.search.test.hql.treewalkonly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.engine.SearchFactoryImplementor;
import org.hibernate.search.test.SearchTestCase;

/**
 * @author Sanne Grinovero
 */
public class LuceneParseTest extends SearchTestCase {
	
	public void testClassicHQLAggregationReturnTypes() {
		List results = executeHQL( "select count(*) from Human h" );
	}
	
	private List executeHQL(String hql){
		LuceneQueryWalker queryTranslator = createNewQueryTranslator( hql, sfi() );
		return null;
	}
	
	private SessionFactoryImplementor sfi() {
		return (SessionFactoryImplementor) getSessions();
	}

	protected LuceneQueryWalker createNewQueryTranslator(String hql, SessionFactoryImplementor sfimpl) {
		return createNewQueryTranslator( hql, new HashMap(), false, sfimpl, getSearchFactory() );
	}
	
	protected LuceneQueryWalker createNewQueryTranslator(String hql, Map replacements, boolean scalar, SessionFactoryImplementor sessionFactory, SearchFactory searchFactory) {
		LuceneQueryWalker queryWalker = new LuceneQueryWalker("", hql, replacements, sessionFactory, (SearchFactoryImplementor) searchFactory);
		queryWalker.compile( replacements, scalar );
		return queryWalker;
	}

	protected Class<?>[] getAnnotatedClasses() {
		return new Class[] { Human.class };
	}

}
