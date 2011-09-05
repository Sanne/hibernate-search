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
package org.hibernate.search.test.query.facet;

import java.util.Iterator;
import java.util.List;

import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.query.facet.Facet;
import org.hibernate.search.query.facet.FacetingRequest;

/**
 * @author Hardy Pragnesh
 */
public class ManyToOneFacetingTest extends AbstractFacetTest {
	private final String indexFieldName = "companyfacilities.country";
	private final String facetName = "countryfacility";

	public void testSimpleFaceting() throws Exception {
		FacetingRequest request = queryBuilder( Company.class ).facet().name( facetName ).onField( indexFieldName )
				.discrete().createFacetingRequest();
		FullTextQuery query = queryCompanyWithFacet( request );

		List<Facet> facetList = query.getFacetManager().getFacets( facetName );
		assertEquals( "Wrong number of facets", 2, facetList.size() );

		// check count in facet
		Iterator<Facet> itr = facetList.iterator();
		while ( itr.hasNext() ) {
			Facet item = itr.next();
			assertEquals( "Wrong count of facet", 1, item.getCount() );
		}

	}

	private FullTextQuery queryCompanyWithFacet(FacetingRequest request) {
		Query luceneQuery = queryBuilder( Company.class ).keyword().onField( "companyName" ).matching( "ABC" )
				.createQuery();
		FullTextQuery query = fullTextSession.createFullTextQuery( luceneQuery, Company.class );
		query.getFacetManager().enableFaceting( request );
		assertEquals( "Wrong number of query matches", 1, query.getResultSize() );
		return query;
	}

	public void loadTestData(Session session) {
		Transaction tx = session.beginTransaction();

		Company a = new Company( "ABC" );
		session.save( a );

		Companyfacility us = new Companyfacility( a, "US" );
		session.save( us );

		Companyfacility india = new Companyfacility( a, "INDIA" );
		session.save( india );

		tx.commit();
		session.clear();
	}

	protected Class<?>[] getAnnotatedClasses() {
		return new Class[] { Company.class, Companyfacility.class };
	}
}
