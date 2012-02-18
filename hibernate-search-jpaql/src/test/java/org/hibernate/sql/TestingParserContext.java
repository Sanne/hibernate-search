package org.hibernate.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.sql.ast.common.ParserContext;

public class TestingParserContext extends DefaultParsingContext implements ParserContext {
	
	//map of <entityName,List entityImplementors>
	private final HashMap<String,List> knownEntities = new HashMap<String,List>();
	
	public TestingParserContext(String... validEntities) {
		for (int i = 0; i < validEntities.length; i++) {
			String entityName = validEntities[i];
			ArrayList implementors = new ArrayList();
			implementors.add( entityName );
			knownEntities.put( validEntities[i], implementors );
		}
	}

	public List getEntityImplementors(String entityName) {
		return knownEntities.get( entityName );
	}

}
