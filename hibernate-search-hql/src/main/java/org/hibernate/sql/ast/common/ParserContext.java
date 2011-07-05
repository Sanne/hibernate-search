package org.hibernate.sql.ast.common;

import java.util.List;

import org.antlr.runtime.Token;

public interface ParserContext {

	Token buildUniqueImplicitAlias();
	
	List getEntityImplementors(String entityName);

}
