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
package org.hibernate.sql;

import junit.framework.Assert;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.hibernate.search.engine.spi.SearchFactoryImplementor;
import org.hibernate.search.query.dsl.impl.ConnectedQueryContextBuilder;
import org.hibernate.sql.ast.common.ParserContext;
import org.hibernate.sql.ast.origin.hql.parse.HQLLexer;
import org.hibernate.sql.ast.origin.hql.parse.HQLParser;
import org.hibernate.sql.ast.origin.hql.resolve.LuceneJPQLWalker;
import org.junit.Test;


/**
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2012 Red Hat Inc.
 */
public class TreeWalkTest {

	@Test
	public void astWalkTest() {
		SearchFactoryMock searchFactory = new SearchFactoryMock();
		//generated alias:
		LuceneJPQLWalker walker = assertTreeParsed( null, "from com.acme.EntityName e where e.name = 'same'" , searchFactory );
		System.out.println( walker );
	}

	private LuceneJPQLWalker assertTreeParsed(ParserContext context, String input, SearchFactoryImplementor searchFactory) {
		HQLLexer lexed = new HQLLexer( new ANTLRStringStream( input ) );
		CommonTokenStream tokens = new CommonTokenStream( lexed );
		
		CommonTree tree = null;
		HQLParser parser = new HQLParser( tokens );
		if ( context != null ) {
			parser.setParserContext( context );
		}
		try {
			HQLParser.statement_return r = parser.statement();
			tree = (CommonTree) r.getTree();
		}
		catch (RecognitionException e) {
			Assert.fail( e.getMessage() );
		}

		if ( tree != null ) {
			// To walk the resulting tree we need a treenode stream:
			CommonTreeNodeStream treeStream = new CommonTreeNodeStream( tree );
			
			// AST nodes have payloads referring to the tokens from the Lexer:
			treeStream.setTokenStream( tokens );
			
			// Finally create the treewalker:
			LuceneJPQLWalker walker = new LuceneJPQLWalker( treeStream, searchFactory );
			try {
				walker.statement();
				return walker;
			}
			catch (RecognitionException e) {
				Assert.fail( e.getMessage() );
			}
		}
		return null; // failed
	}

	private class SearchFactoryMock extends BaseSearchFactoryImplementor {
		
	}


}
