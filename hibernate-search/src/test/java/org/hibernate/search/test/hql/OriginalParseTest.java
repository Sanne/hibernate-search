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
import java.util.Map;

import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.hibernate.hql.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.ast.QueryTranslatorImpl;

/**
 * @author Sanne Grinovero
 *
 */
public class OriginalParseTest extends LuceneParseTest {
	
	@Override
	protected QueryTranslator createNewQueryTranslator(String hql, Map replacements, boolean scalar, SessionFactoryImplementor factory) {
		QueryTranslatorFactory ast = new ASTQueryTranslatorFactory();
		QueryTranslatorImpl newQueryTranslator = (QueryTranslatorImpl) ast.createQueryTranslator( hql, hql, Collections.EMPTY_MAP, factory );
		newQueryTranslator.compile( replacements, scalar );
		return newQueryTranslator;
	}
	
}
