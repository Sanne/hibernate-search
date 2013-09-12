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
package org.hibernate.search.jpa.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.MassIndexer;
import org.hibernate.search.Search;
import org.hibernate.search.SearchException;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.util.logging.impl.Log;
import org.hibernate.search.util.logging.impl.LoggerFactory;

/**
 * @author Emmanuel Bernard
 */
public class FullTextEntityManagerImpl implements EntityManagerContractOverrides, Serializable {

	private static final Log log = LoggerFactory.make();

	private final EntityManager em;
	private FullTextSession ftSession;

	public FullTextEntityManagerImpl(EntityManager em) {
		if ( em == null ) {
			throw log.getNullSessionPassedToFullEntityManagerCreationException();
		}
		this.em = em;
	}

	private FullTextSession getFullTextSession() {
		if ( ftSession == null ) {
			Object delegate = em.getDelegate();
			if ( delegate == null ) {
				throw new SearchException(
						"Trying to use Hibernate Search without an Hibernate EntityManager (no delegate)"
				);
			}
			else if ( Session.class.isAssignableFrom( delegate.getClass() ) ) {
				ftSession = Search.getFullTextSession( (Session) delegate );
			}
			else if ( EntityManager.class.isAssignableFrom( delegate.getClass() ) ) {
				//Some app servers wrap the EM twice
				delegate = ( (EntityManager) delegate ).getDelegate();
				if ( delegate == null ) {
					throw new SearchException(
							"Trying to use Hibernate Search without an Hibernate EntityManager (no delegate)"
					);
				}
				else if ( Session.class.isAssignableFrom( delegate.getClass() ) ) {
					ftSession = Search.getFullTextSession( (Session) delegate );
				}
				else {
					throw new SearchException(
							"Trying to use Hibernate Search without an Hibernate EntityManager: " + delegate.getClass()
					);
				}
			}
			else {
				throw new SearchException(
						"Trying to use Hibernate Search without an Hibernate EntityManager: " + delegate.getClass()
				);
			}
		}
		return ftSession;
	}

	@Override
	public FullTextQuery createFullTextQuery(org.apache.lucene.search.Query luceneQuery, Class<?>... entities) {
		FullTextSession ftSession = getFullTextSession();
		return new FullTextQueryImpl( ftSession.createFullTextQuery( luceneQuery, entities ), ftSession );
	}

	@Override
	public <T> void index(T entity) {
		getFullTextSession().index( entity );
	}

	@Override
	public SearchFactory getSearchFactory() {
		return getFullTextSession().getSearchFactory();
	}

	@Override
	public <T> void purge(Class<T> entityType, Serializable id) {
		getFullTextSession().purge( entityType, id );
	}

	@Override
	public <T> void purgeAll(Class<T> entityType) {
		getFullTextSession().purgeAll( entityType );
	}

	@Override
	public void flushToIndexes() {
		getFullTextSession().flushToIndexes();
	}

	@Override
	public void clear() {
		//TODO HSEARCH-1270
		em.clear();
	}

	@Override
	public <T> T unwrap(Class<T> type) {
		if ( type.equals( FullTextSession.class ) ) {
			@SuppressWarnings("unchecked")
			final T ftSession = (T) Search.getFullTextSession( em.unwrap( Session.class ) );
			return ftSession;
		}
		else {
			return em.unwrap( type );
		}
	}

	@Override
	public MassIndexer createIndexer(Class<?>... types) {
		return getFullTextSession().createIndexer( types );
	}

}
