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

import java.util.Map;

import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.FilterTranslator;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sanne Grinovero
 * @see org.hibernate.hql.ast.ASTQueryTranslatorFactory
 */
public class JPALuceneQueryTranslatorFactory implements QueryTranslatorFactory {
	
	private static final Logger log = LoggerFactory.getLogger( JPALuceneQueryTranslatorFactory.class );
	
	public JPALuceneQueryTranslatorFactory() {
		log.info( "Using JPALuceneQueryTranslatorFactory" );
	}
	
	public QueryTranslator createQueryTranslator(
			String queryIdentifier,
			String queryString,
			Map filters,
			SessionFactoryImplementor factory) {
		return new LuceneQueryTranslatorImpl(queryIdentifier, queryString, filters, factory);
	}
	
	public FilterTranslator createFilterTranslator(
			String queryIdentifier,
			String queryString,
			Map filters,
			SessionFactoryImplementor factory) {
		return new LuceneQueryTranslatorImpl(queryIdentifier, queryString, filters, factory);
	}
	
}
