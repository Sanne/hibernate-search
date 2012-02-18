package org.hibernate.sql;

import junit.framework.Assert;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.hibernate.sql.ast.common.ParserContext;
import org.hibernate.sql.ast.origin.hql.parse.HQLLexer;
import org.hibernate.sql.ast.origin.hql.parse.HQLParser;
import org.junit.Test;

public class ParsingTest {

	@Test
	public void testSuperSimpleQuery() {
		ParserContext context = new TestingParserContext( "EntityName" );
		//generated alias:
		assertTreeParsed( context, "from EntityName",
			"(QUERY (QUERY_SPEC (SELECT_FROM (from (PERSISTER_SPACE (ENTITY_PERSISTER_REF EntityName <gen:0>))) (SELECT (SELECT_LIST (SELECT_ITEM <gen:0>))))))");
	}

	@Test
	public void testSimpleQuery() {
		ParserContext context = new TestingParserContext( "com.acme.EntityName" );
		//full selection with specified alias:
		assertTreeParsed( context, "select e from com.acme.EntityName e",
			"(QUERY (QUERY_SPEC (SELECT_FROM (from (PERSISTER_SPACE (ENTITY_PERSISTER_REF com.acme.EntityName e))) (select (SELECT_LIST (SELECT_ITEM (PATH e)))))))");
	}

	@Test
	public void testSimpleFromQuery() {
		ParserContext context = new TestingParserContext( "com.acme.EntityName" );
		//abbreviated form:
		assertTreeParsed( context, "from com.acme.EntityName e",
			"(QUERY (QUERY_SPEC (SELECT_FROM (from (PERSISTER_SPACE (ENTITY_PERSISTER_REF com.acme.EntityName e))) (SELECT (SELECT_LIST (SELECT_ITEM e))))))");
	}

	@Test
	public void testSimpleQueryDefaultContext() {
		//generated alias:
		assertTreeParsed( null, "from com.acme.EntityName e",
			"(QUERY (QUERY_SPEC (SELECT_FROM (from (PERSISTER_SPACE (ENTITY_PERSISTER_REF com.acme.EntityName e))) (SELECT (SELECT_LIST (SELECT_ITEM e))))))");
	}

	private void assertTreeParsed(ParserContext context, String input, String treeExpectation) {
		HQLLexer lexed = new HQLLexer( new ANTLRStringStream( input ) );
		CommonTokenStream tokens = new CommonTokenStream( lexed );
		
		HQLParser parser = new HQLParser( tokens );
		if ( context != null ) {
			parser.setParserContext( context );
		}
		try {
			HQLParser.statement_return r = parser.statement();
			Assert.assertEquals( treeExpectation, ( (CommonTree) r.getTree() ).toStringTree() );
		}
		catch (RecognitionException e) {
			Assert.fail( e.getMessage() );
		}
	}
}
