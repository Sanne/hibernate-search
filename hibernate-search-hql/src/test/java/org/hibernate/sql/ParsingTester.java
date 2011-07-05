package org.hibernate.sql;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.hibernate.sql.ast.common.ParserContext;
import org.hibernate.sql.ast.origin.hql.parse.HQLLexer;
import org.hibernate.sql.ast.origin.hql.parse.HQLParser;

public class ParsingTester {
	
	public static void main(String args[]) throws Exception {
		HQLLexer lexed = new HQLLexer( new ANTLRStringStream( "from com.acme.EntityName e" ) );
		
		CommonTokenStream tokens = new CommonTokenStream(lexed);
		
		ParserContext context = new TestingParserContext( "com.acme.EntityName" );
		HQLParser parser = new HQLParser(tokens);
		parser.setParserContext( context );

		HQLParser.statement_return r = parser.statement();
		// print tree if building trees
		if (r != null)
			System.out.println( ((CommonTree) r.getTree()).toStringTree() );
	}
}
