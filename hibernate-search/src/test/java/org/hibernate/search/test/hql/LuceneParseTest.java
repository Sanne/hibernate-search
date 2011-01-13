/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat, Inc. and/or its affiliates or third-party contributors as
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
package org.hibernate.search.test.hql;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.hibernate.hql.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.ast.QueryTranslatorImpl;
import org.hibernate.search.test.SearchTestCase;

/**
 * @author Sanne Grinovero
 *
 */
public class LuceneParseTest extends SearchTestCase {
	
	public LuceneParseTest() {
//		super( "Lucene/HQL" );
	}

	public void configure(Configuration cfg) {
		super.configure( cfg );
		cfg.setProperty( Environment.QUERY_TRANSLATOR, JPALuceneQueryTranslatorFactory.class.getName() );
	}
	
	public void testClassicHQLAggregationReturnTypes() {
		// EJB3: COUNT returns Long
		QueryTranslator translator = createNewQueryTranslator( "select count(*) from Human h", sfi() );
		assertEquals( "incorrect return type count", 1, translator.getReturnTypes().length );
		assertEquals( "incorrect return type", Hibernate.LONG, translator.getReturnTypes()[0] );
	}
	
	private SessionFactoryImplementor sfi() {
		return (SessionFactoryImplementor) getSessions();
	}

	protected QueryTranslator createNewQueryTranslator(String hql, SessionFactoryImplementor sfimpl) {
		return createNewQueryTranslator( hql, new HashMap(), false, sfimpl );
	}
	
	protected QueryTranslator createNewQueryTranslator(String hql, Map replacements, boolean scalar, SessionFactoryImplementor factory) {
		QueryTranslatorFactory ast = new JPALuceneQueryTranslatorFactory();
		LuceneQueryTranslatorImpl newQueryTranslator = (LuceneQueryTranslatorImpl) ast.createQueryTranslator( hql, hql, Collections.EMPTY_MAP, factory );
		newQueryTranslator.compile( replacements, scalar );
		return newQueryTranslator;
	}

	protected Class<?>[] getAnnotatedClasses() {
		return new Class[] { Human.class };
	}

}
