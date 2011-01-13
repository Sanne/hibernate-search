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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.QueryException;
import org.hibernate.ScrollableResults;
import org.hibernate.engine.QueryParameters;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.event.EventSource;
import org.hibernate.hql.FilterTranslator;
import org.hibernate.hql.ParameterTranslations;
import org.hibernate.hql.antlr.HqlTokenTypes;
import org.hibernate.hql.antlr.SqlTokenTypes;
import org.hibernate.hql.ast.HqlParser;
import org.hibernate.hql.ast.QuerySyntaxException;
import org.hibernate.hql.ast.QueryTranslatorImpl.JavaConstantConverter;
import org.hibernate.hql.ast.util.ASTPrinter;
import org.hibernate.hql.ast.util.NodeTraverser;
import org.hibernate.search.util.LoggerFactory;
import org.hibernate.type.Type;
import org.slf4j.Logger;

import antlr.ANTLRException;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.collections.AST;

/**
 * @author Sanne Grinovero
 * @see org.hibernate.hql.ast.QueryTranslatorImpl
 */
public class LuceneQueryTranslatorImpl implements FilterTranslator {
	
	private static final Logger log = LoggerFactory.make();
	private static final Logger AST_LOG = org.slf4j.LoggerFactory.getLogger( "org.hibernate.hql.ast.AST" );
	
	private final String queryIdentifier;
	private final String hql;
	private Map enabledFilters;
	private final SessionFactoryImplementor factory;
	private boolean compiled = false;

	private Map tokenReplacements;

	private boolean shallowQuery;

	/**
	 * Creates a new HQL-tree walker creating Lucene queries
	 *
	 * @param queryIdentifier The query-identifier (used in stats collection)
	 * @param query The hql query to translate
	 * @param enabledFilters Currently enabled filters
	 * @param factory The session factory constructing this translator instance.
	 */
	@SuppressWarnings("rawtypes")
	public LuceneQueryTranslatorImpl(String queryIdentifier, String queryString, Map filters, SessionFactoryImplementor factory) {
		this.queryIdentifier = queryIdentifier;
		this.hql = queryString;
		this.enabledFilters = filters;
		this.factory = factory;
	}

	public void compile(Map replacements, boolean shallow) throws QueryException, MappingException {
		doCompile( replacements, shallow, null );
	}
	
	public void compile(String collectionRole, Map replacements, boolean shallow) throws QueryException, MappingException {
		doCompile( replacements, shallow, collectionRole );
	}
	
	/**
	 * Performs both filter and non-filter compiling.
	 *
	 * @param replacements   Defined query substitutions.
	 * @param shallow        Does this represent a shallow (scalar or entity-id) select?
	 * @param collectionRole the role name of the collection used as the basis for the filter, NULL if this
	 *                       is not a filter.
	 */
	private synchronized void doCompile(Map replacements, boolean shallow, String collectionRole) {
		// If the query is already compiled, skip the compilation.
		if ( compiled ) {
			log.debug( "compile() : The query is already compiled, skipping..." );
			return;
		}
		
		// Remember the parameters for the compilation.
		this.tokenReplacements = replacements;
		if ( tokenReplacements == null ) {
			tokenReplacements = Collections.EMPTY_MAP;
		}
		this.shallowQuery = shallow;

		try {
			// PHASE 1 : Parse the HQL into an AST.
			HqlParser parser = parse( true );

			// PHASE 2 : Analyze the HQL AST, and produce an SQL AST.
			HqlLuceneWalker w = analyze( parser, collectionRole );

			AST ast = w.getAST();

//			if ( sqlAst.needsExecutor() ) {
//				statementExecutor = buildAppropriateStatementExecutor( w );
//			}
//			else {
//				// PHASE 3 : Generate the SQL.
//				generate( ( QueryNode ) sqlAst );
//				queryLoader = new QueryLoader( this, factory, w.getSelectClause() );
//			}

			compiled = true;
		}
		catch ( QueryException qe ) {
			qe.setQueryString( hql );
			throw qe;
		}
		catch ( RecognitionException e ) {
			// we do not actually propagate ANTLRExceptions as a cause, so
			// log it here for diagnostic purposes
			if ( log.isTraceEnabled() ) {
				log.trace( "converted antlr.RecognitionException", e );
			}
			throw QuerySyntaxException.convert( e, hql );
		}
		catch ( ANTLRException e ) {
			// we do not actually propagate ANTLRExceptions as a cause, so
			// log it here for diagnostic purposes
			if ( log.isTraceEnabled() ) {
				log.trace( "converted antlr.ANTLRException", e );
			}
			throw new QueryException( e.getMessage(), hql );
		}

		this.enabledFilters = null; //only needed during compilation phase...
		
	}
	
	private HqlParser parse(boolean filter) throws TokenStreamException, RecognitionException {
		// Parse the query string into an HQL AST.
		HqlParser parser = HqlParser.getInstance( hql );
		parser.setFilter( filter );

		if ( log.isDebugEnabled() ) {
			log.debug( "parse() - HQL: " + hql );
		}
		parser.statement();

		AST hqlAst = parser.getAST();

		JavaConstantConverter converter = new JavaConstantConverter();
		NodeTraverser walker = new NodeTraverser( converter );
		walker.traverseDepthFirst( hqlAst );

		showHqlAst( hqlAst );

		parser.getParseErrorHandler().throwQueryException();
		return parser;
	}
	
	private HqlLuceneWalker analyze(HqlParser parser, String collectionRole) throws QueryException, RecognitionException {
		HqlLuceneWalker w = new HqlLuceneWalker( this, factory, parser, tokenReplacements, collectionRole );
		AST hqlAst = parser.getAST();

		// Transform the tree.
		w.statement( hqlAst );

		if ( AST_LOG.isDebugEnabled() ) {
			ASTPrinter printer = new ASTPrinter( SqlTokenTypes.class );
			AST_LOG.debug( printer.showAsString( w.getAST(), "--- SQL AST ---" ) );
		}

//		w.getParseErrorHandler().throwQueryException();

		return w;
	}
	
	
	
	void showHqlAst(AST hqlAst) {
		if ( AST_LOG.isDebugEnabled() ) {
			ASTPrinter printer = new ASTPrinter( HqlTokenTypes.class );
			AST_LOG.debug( printer.showAsString( hqlAst, "--- HQL AST ---" ) );
		}
	}
	
	public Map getEnabledFilters() {
		return this.enabledFilters;
	}
	
	//*************************************************************** TODO:

	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#list(org.hibernate.engine.SessionImplementor, org.hibernate.engine.QueryParameters)
	 */
	public List list(SessionImplementor session, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#iterate(org.hibernate.engine.QueryParameters, org.hibernate.event.EventSource)
	 */
	public Iterator iterate(QueryParameters queryParameters, EventSource session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#scroll(org.hibernate.engine.QueryParameters, org.hibernate.engine.SessionImplementor)
	 */
	public ScrollableResults scroll(QueryParameters queryParameters, SessionImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#executeUpdate(org.hibernate.engine.QueryParameters, org.hibernate.engine.SessionImplementor)
	 */
	public int executeUpdate(QueryParameters queryParameters, SessionImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#getQuerySpaces()
	 */
	public Set getQuerySpaces() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#getQueryIdentifier()
	 */
	public String getQueryIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#getSQLString()
	 */
	public String getSQLString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#collectSqlStrings()
	 */
	public List collectSqlStrings() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#getQueryString()
	 */
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#getReturnTypes()
	 */
	public Type[] getReturnTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#getReturnAliases()
	 */
	public String[] getReturnAliases() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#getColumnNames()
	 */
	public String[][] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#getParameterTranslations()
	 */
	public ParameterTranslations getParameterTranslations() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#validateScrollability()
	 */
	public void validateScrollability() throws HibernateException {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#containsCollectionFetches()
	 */
	public boolean containsCollectionFetches() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.hql.QueryTranslator#isManipulationStatement()
	 */
	public boolean isManipulationStatement() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
