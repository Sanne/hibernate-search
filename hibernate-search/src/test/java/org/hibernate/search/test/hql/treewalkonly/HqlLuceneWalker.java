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
package org.hibernate.search.test.hql.treewalkonly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.antlr.SqlTokenTypes;
import org.hibernate.hql.ast.ErrorCounter;
import org.hibernate.hql.ast.HqlParser;
import org.hibernate.hql.ast.HqlSqlWalker;
import org.hibernate.hql.ast.ParseErrorHandler;
import org.hibernate.hql.ast.SqlASTFactory;
import org.hibernate.hql.ast.tree.FromClause;
import org.hibernate.hql.ast.tree.SelectClause;
import org.hibernate.hql.ast.tree.SelectExpression;
import org.hibernate.hql.ast.util.ASTPrinter;
import org.hibernate.hql.ast.util.AliasGenerator;
import org.hibernate.hql.ast.util.LiteralProcessor;
import org.hibernate.hql.ast.util.SessionFactoryHelper;
import org.hibernate.search.util.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author Sanne Grinovero
 * @see org.hibernate.hql.ast.HqlSqlWalker
 */
public class HqlLuceneWalker extends HqlSqlWalker { // should extend HqlSqlBaseWalker but needs to be type compatible to HqlSqlWalker, see ctor of SqlASTFactory
	
	private static final Logger log = LoggerFactory.make();
	private final boolean trace = log.isTraceEnabled();

	private final LuceneQueryWalker luceneQueryTranslatorImpl;
	
	private final HqlParser hqlParser;
	private final SessionFactoryHelper sessionFactoryHelper;
	private final Map tokenReplacements;
	private final AliasGenerator aliasGenerator = new AliasGenerator();
	private final LiteralProcessor literalProcessor;
	private final ParseErrorHandler parseErrorHandler;
	private final ASTPrinter printer;
	private final String collectionFilterRole;

	private FromClause currentFromClause = null;
	private SelectClause selectClause;

	/**
	 * Maps each top-level result variable to its SelectExpression;
	 * (excludes result variables defined in subqueries)
	 **/
	private Map<String, SelectExpression> selectExpressionsByResultVariable = new HashMap();

	private Set querySpaces = new HashSet();

	private int parameterCount;
	private Map namedParameters = new HashMap();
	private ArrayList parameters = new ArrayList();
	private int numberOfParametersInSetClause;
	private int positionalParameterCount;

	private ArrayList assignmentSpecifications = new ArrayList();

	private int impliedJoinType;

	/**
	 * @param luceneQueryTranslatorImpl
	 * @param factory
	 * @param parser
	 * @param tokenReplacements
	 * @param collectionRole
	 */
	public HqlLuceneWalker(LuceneQueryWalker luceneQueryTranslatorImpl, SessionFactoryImplementor factory, HqlParser parser, @SuppressWarnings("rawtypes") Map tokenReplacements, String collectionRole) {
		super(null, factory, parser, tokenReplacements, collectionRole); //TODO to be removed - we don't actually want to extend HqlSqlWalker
		this.luceneQueryTranslatorImpl = luceneQueryTranslatorImpl;
		setASTFactory( new SqlASTFactory( this ) );
		// Initialize the error handling delegate.
		this.parseErrorHandler = new ErrorCounter();
		this.sessionFactoryHelper = new SessionFactoryHelper( factory ); //TODO could become a custom Search-aware helper
		this.literalProcessor = new LiteralProcessor( this );
		this.tokenReplacements = tokenReplacements;
		this.collectionFilterRole = collectionRole;
		this.hqlParser = parser;
		this.printer = new ASTPrinter( SqlTokenTypes.class );
	}
	
	@Override
	public boolean isShallowQuery() {
		return true;//TODO find out what this means
	}
	
	@Override
	public Map getEnabledFilters() {
		return Collections.emptyMap();
	}
	
}
