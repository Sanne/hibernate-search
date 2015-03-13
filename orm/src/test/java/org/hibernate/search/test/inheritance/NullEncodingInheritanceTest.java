/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.test.inheritance;

import java.util.Arrays;
import java.util.List;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.test.SearchTestBase;
import org.hibernate.testing.TestForIssue;
import org.junit.Assert;
import org.junit.Test;

@TestForIssue(jiraKey = "HSEARCH-1830")
public class NullEncodingInheritanceTest extends SearchTestBase {

	@Test
	public void testSearchUnindexClass() throws Exception {
		storeAFlyingBox( 1l, "FOO", "XT1");
		storeAFlyingBox( 2l, null, "XT2"); // null for 'barcode' field
		FullTextSession s = Search.getFullTextSession( openSession() );
		Transaction tx = s.beginTransaction();

		List query = runProjectionQueryOnAllDocuments( s, "notexisting" );
		Assert.assertEquals( 2, query.size() );
		assertContainsProjectionResult( query, new Object[]{ null } );

		query = runProjectionQueryOnAllDocuments( s, "engineModel" );
		Assert.assertEquals( 2, query.size() );
		assertContainsProjectionResult( query, new Object[]{ "XT1" } );
		assertContainsProjectionResult( query, new Object[]{ "XT2" } );

		query = runProjectionQueryOnAllDocuments( s, "engineModel", "barcode" );
		Assert.assertEquals( 2, query.size() );
		assertContainsProjectionResult( query, new Object[]{ "XT1", "FOO" } );
		assertContainsProjectionResult( query, new Object[]{ "XT2", null } );

		//Let's also verify that the null value is being encoded with the requested marked:
		verifyNativeEncoding( s );

		//Now using the DSL, with explicit Null token:
		query = runProjectionUsingDSL( s, Box.CODE_FOR_MISSING_BARCODE, "engineModel", "barcode" );
		Assert.assertEquals( 1, query.size() );
		assertContainsProjectionResult( query, new Object[]{ "XT2", null } );

		//Now using the DSL, but using null as value to match:
		query = runProjectionUsingDSL( s, null, "engineModel", "barcode" );
		Assert.assertEquals( 1, query.size() );
		assertContainsProjectionResult( query, new Object[]{ "XT2", null } );

		tx.commit();
		s.close();
	}

	private List runProjectionUsingDSL(FullTextSession s, Object nullToken, String... fields) {
		QueryBuilder qb = getSearchFactory().buildQueryBuilder().forEntity( FlyingBox.class ).get();
		Query luceneQuery = qb.keyword().onField( "barcode" ).matching( nullToken ).createQuery();
		FullTextQuery fullTextQuery = s.createFullTextQuery( luceneQuery, FlyingBox.class );
		fullTextQuery.setProjection( fields );
		return fullTextQuery.list();
	}

	private void verifyNativeEncoding(FullTextSession s) {
		TermQuery termQuery = new TermQuery( new Term( "barcode", Box.CODE_FOR_MISSING_BARCODE ) );
		FullTextQuery query = s.createFullTextQuery( termQuery, Box.class );
		Assert.assertEquals( 1, query.getResultSize() );
		Assert.assertEquals( 1, query.list().size() );
	}

	private void assertContainsProjectionResult(List query, Object[] expectedProjection) {
		//This is to ignore the sort order of the results:
		for ( int i = 0; i < query.size(); i++ ) {
			if ( Arrays.equals( (Object[])query.get( i ), expectedProjection ) ) {
				return;
			}
		}
		Assert.fail( "The query didn't contain the expected projection among the results" );
	}

	private List runProjectionQueryOnAllDocuments(FullTextSession s, String... fields) {
		Query luceneQuery = new MatchAllDocsQuery();
		FullTextQuery fullTextQuery = s.createFullTextQuery( luceneQuery, FlyingBox.class );
		fullTextQuery.setProjection( fields );
		return fullTextQuery.list();
	}

	private void storeAFlyingBox(long id, String barcode, String engineModel) {
		FullTextSession s = Search.getFullTextSession( openSession() );
		Transaction tx = s.beginTransaction();

		FlyingBox box = new FlyingBox();
		box.id = id;
		box.barcode = barcode;
		box.engineModel = engineModel;

		s.save( box );
		tx.commit();
		s.close();
	}

	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class[] {
				Box.class,
				FlyingBox.class
		};
	}

}
