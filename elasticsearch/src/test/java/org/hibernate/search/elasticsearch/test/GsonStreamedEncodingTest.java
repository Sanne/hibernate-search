/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

package org.hibernate.search.elasticsearch.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.search.elasticsearch.dialect.impl.es52.Elasticsearch52Dialect;
import org.hibernate.search.elasticsearch.impl.JsonBuilder;
import org.hibernate.search.elasticsearch.util.impl.GsonHttpEntity;
import org.hibernate.search.testsupport.TestForIssue;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.http.nio.ContentEncoder;
import org.apache.http.nio.IOControl;

import static java.util.Collections.singletonList;
import static org.apache.commons.codec.binary.Hex.encodeHexString;
import static org.apache.commons.codec.digest.DigestUtils.getSha256Digest;
import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Tests for GsonHttpEntity to be able to write the whole JSON string
 * out correctly, and produce a matching sha256 digest.
 */
@TestForIssue( jiraKey = "HSEARCH-2818" )
public class GsonStreamedEncodingTest {

	public static final int MAX_TESTING_BUFFER_BYTES = 200;

	private static final Gson gson = new Elasticsearch52Dialect()
			.createGsonProvider()
			.getGson();

	@Test
	public void testEmptyJSON() {
		JsonObject body1 = JsonBuilder.object().build();
		final List<JsonObject> list = singletonList( body1 );
		verifyProducedContent( list );
		verifySha256Signature( list );
		verifyOutput( "{}\n", list );
	}

	@Test
	public void testSinglePropertyJSON() {
		JsonObject body1 = JsonBuilder.object()
				.add( "version", JsonBuilder.object()
						.addProperty( "number", "5.5.0" )
				).build();
		final List<JsonObject> list = singletonList( body1 );
		verifyProducedContent( list );
		verifySha256Signature( list );
		verifyOutput( "{\"version\":{\"number\":\"5.5.0\"}}\n", list );
	}

	@Test
	public void testTripleBulkJSON() {
		final List<JsonObject> list = new ArrayList<>( 3 );
		list.add( JsonBuilder.object().build() );
		list.add( JsonBuilder.object()
				.add( "version", JsonBuilder.object()
						.addProperty( "number", "5.5.0" ) )
				.build() );
		list.add( JsonBuilder.object().build() );
		verifyProducedContent( list );
		verifySha256Signature( list );
		verifyOutput(
					"{}\n" +
					"{\"version\":{\"number\":\"5.5.0\"}}\n" +
					"{}\n",
					list );
	}

	private void verifyOutput(final String expected, final List<JsonObject> list) {
		assertEquals( expected, encodeToString( list ) );
	}

	private void verifySha256Signature(final List<JsonObject> jsonObjects) {
		final String optimisedEncoding = optimisedSha256( jsonObjects );
		final String traditionalEncoding = traditionalSha256( jsonObjects );
		assertEquals( "SHA-256 signatures not matching", traditionalEncoding, optimisedEncoding );
	}

	private String optimisedSha256(final List<JsonObject> bodyParts) {
		notEmpty( bodyParts );
		try ( GsonHttpEntity entity = new GsonHttpEntity( gson, bodyParts ) ) {
			final MessageDigest digest = getSha256Digest();
			entity.fillDigest( digest );
			return encodeHexString( digest.digest() );
		}
		catch (IOException e) {
			throw new RuntimeException( "We're mocking IO operations, this should not happen?", e );
		}
	}

	private String traditionalSha256(final List<JsonObject> jsonObjects) {
		return sha256Hex( traditionalEncoding( jsonObjects ) );
	}

	private void verifyProducedContent(final List<JsonObject> jsonObjects) {
		assertArrayEquals(
				traditionalEncoding( jsonObjects ),
				optimisedEncoding( jsonObjects ) );
	}

	byte[] optimisedEncoding(List<JsonObject> bodyParts) {
		notEmpty( bodyParts );
		try ( GsonHttpEntity entity = new GsonHttpEntity( gson, bodyParts ) ) {
			IOControl fakeIO = new FakeIOControl();
			HeapContentEncoder sink = new HeapContentEncoder();
			int loopCounter = 0;
			while ( sink.isCompleted() == false ) {
				entity.produceContent( sink, fakeIO );
				sink.setNextAcceptedBytesSize( loopCounter++ );
			}
			return sink.flipAndRead();
		}
		catch (IOException e) {
			throw new RuntimeException( "We're mocking IO operations, this should not happen?", e );
		}
	}

	private void notEmpty(final List<JsonObject> bodyParts) {
		assertFalse( "Pointless to test this, we don't use this strategy for empty blocks", bodyParts.isEmpty() );
	}

	/**
	 * This is the simplest encoding strategy; we don't use this as
	 * it would require to allocate significantly larger intermediate
	 * buffers. See also HSEARCH-2818.
	 */
	byte[] traditionalEncoding(final List<JsonObject> bodyParts) {
		return encodeToString( bodyParts ).getBytes( StandardCharsets.UTF_8 );
	}

	private String encodeToString(final List<JsonObject> bodyParts) {
		notEmpty( bodyParts );
		final StringBuilder builder = new StringBuilder();
		for ( JsonObject bodyPart : bodyParts ) {
			gson.toJson( bodyPart, builder );
			builder.append( '\n' );
		}
		return builder.toString();
	}

	private static final class HeapContentEncoder implements ContentEncoder {

		private boolean contentComplete = false;
		private int nextWriteAcceptLimit = 0;
		private ByteBuffer buf = ByteBuffer.allocate( MAX_TESTING_BUFFER_BYTES );
		private boolean closed = false;
		private int writeIterationsDetected = 0;

		@Override
		public int write(final ByteBuffer byteBuffer) throws IOException {
			assertFalse( closed );
			int toRead = Math.min( byteBuffer.remaining(), nextWriteAcceptLimit );
			byte[] currentRead = new byte[toRead];
			byteBuffer.get( currentRead );
			buf.put( currentRead );
			writeIterationsDetected++;
			return toRead;
		}

		@Override
		public void complete() throws IOException {
			assertFalse( "Can't mark it 'complete' multiple times", closed );
			contentComplete = true;
		}

		@Override
		public boolean isCompleted() {
			return contentComplete;
		}

		public byte[] flipAndRead() {
			assertFalse( "can read the buffer only once", closed );
			closed = true;
			buf.flip();
			byte[] currentRead = new byte[buf.remaining()];
			buf.get( currentRead );
			return currentRead;
		}

		public void setNextAcceptedBytesSize(int size) {
			this.nextWriteAcceptLimit = size;
		}

		public int getWriteIterationsDetected() {
			return writeIterationsDetected;
		}
	}

	private static final class FakeIOControl implements IOControl {
		@Override
		public void requestInput() {
			fail( "Should not invoke this" );
		}

		@Override
		public void suspendInput() {
			fail( "Should not invoke this" );
		}

		@Override
		public void requestOutput() {
			fail( "Should not invoke this" );
		}

		@Override
		public void suspendOutput() {
			fail( "Should not invoke this" );
		}

		@Override
		public void shutdown() throws IOException {
			fail( "Should not invoke this" );
		}
	}

}
