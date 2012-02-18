package org.hibernate.sql.ast.common;

import java.util.List;

public interface ParserContext {

	String buildUniqueImplicitAlias();

	List getEntityImplementors(String entityName);

}
