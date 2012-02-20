/* 
 * Hibernate, Relational Persistence for Idiomatic Java
 * 
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
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
package org.hibernate.sql.ast.origin.hql.resolve;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.hibernate.search.engine.spi.SearchFactoryImplementor;
import org.hibernate.sql.ast.common.JoinType;
import org.hibernate.sql.ast.origin.hql.resolve.path.PathedPropertyReference;
import org.hibernate.sql.ast.origin.hql.resolve.path.PathedPropertyReferenceSource;

/**
 * @author Sanne Grinovero <sanne@hibernate.org> (C) 2011 Red Hat Inc.
 */
public class LuceneJPQLWalker extends GeneratedHQLResolver {

	/**
	 * Persister space: keep track of aliases and entity names.
	 */
	private final Map<String, String> aliasToEntityType = new HashMap<String, String>();

	/**
	 * Set to true when we are walking in the tree area defining a SELECT type/options
	 */
	private boolean definingSelectStrategy;

	/**
	 * We refer to a SearchFactor to build queries
	 */
	private final SearchFactoryImplementor searchFactory;

	public LuceneJPQLWalker(TreeNodeStream input, SearchFactoryImplementor searchFactory) {
		super( input );
		this.searchFactory = searchFactory;
	}

	/**
	 * See rule entityName
	 */
	protected void registerPersisterSpace(Tree entityName, Tree alias) {
		String put = aliasToEntityType.put( alias.getText(), entityName.getText() );
		if ( put != null && !put.equalsIgnoreCase( entityName.getText() ) ) {
			throw new UnsupportedOperationException(
					"Alias reuse currently not supported: alias " + alias.getText()
							+ " already assigned to type " + put );
		}
	}

	protected boolean isUnqualifiedPropertyReference() {
		throw new UnsupportedOperationException( "must be overridden!" );
	}

	protected PathedPropertyReferenceSource normalizeUnqualifiedPropertyReference(Tree property) {
		//TODO
		return null;
	}

	protected boolean isPersisterReferenceAlias() {
		if ( aliasToEntityType.size() == 1 ) {
			return true; // should be safe
		}
		else {
			throw new UnsupportedOperationException( "Unexpected use case: not implemented yet?" );
		}
	}

	protected PathedPropertyReferenceSource normalizeUnqualifiedRoot(Tree identifier382) {
		throw new UnsupportedOperationException( "must be overridden!" );
	}

	protected PathedPropertyReferenceSource normalizeQualifiedRoot(Tree identifier381) {
		return new PathedPropertyReference( identifier381.getText(), aliasToEntityType );
	}

	protected PathedPropertyReferenceSource normalizePropertyPathIntermediary(
			PathedPropertyReferenceSource source, Tree propertyName) {
		throw new UnsupportedOperationException( "must be overridden!" );
	}

	protected PathedPropertyReferenceSource normalizeIntermediateIndexOperation(
			PathedPropertyReferenceSource propertyReferenceSource, Tree collectionProperty, Tree selector) {
		throw new UnsupportedOperationException( "must be overridden!" );
	}

	protected void normalizeTerminalIndexOperation(
			PathedPropertyReferenceSource propertyReferenceSource, Tree collectionProperty, Tree selector) {
		throw new UnsupportedOperationException( "must be overridden!" );
	}

	protected PathedPropertyReferenceSource normalizeUnqualifiedPropertyReferenceSource(Tree identifier394) {
		throw new UnsupportedOperationException( "must be overridden!" );
	}

	protected Tree normalizePropertyPathTerminus(PathedPropertyReferenceSource source, Tree propertyNameNode) {
		// receives the property name on a specific entity reference _source_
		//TODO ?
		return null;
	}

	protected void pushFromStrategy(
			JoinType joinType,
			Tree assosiationFetchTree,
			Tree propertyFetchTree,
			Tree alias) {
		throw new UnsupportedOperationException( "must be overridden!" );
	}

	protected void pushSelectStrategy() {
		definingSelectStrategy = true;
	}

	protected void popStrategy() {
		definingSelectStrategy = false;
	}
}
