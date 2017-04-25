/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.backend.jgroups.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jgroups.JChannel;
import org.jgroups.MembershipListener;
import org.jgroups.Message;
import org.jgroups.View;
import org.jgroups.blocks.MessageDispatcher;
import org.jgroups.blocks.RequestHandler;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.util.RspList;
import org.jgroups.util.Util;

public class MessageDispatcherTest implements RequestHandler {

	private final JChannel channel;
	private final MessageDispatcher disp;
	private final String nodeName;

	public MessageDispatcherTest(int nodeId) throws Exception {
		this.nodeName = "Node"+nodeId;
		channel = new JChannel( "testing-flush-loopback.xml" );
		disp = new MessageDispatcher( channel, this );
		disp.setMembershipListener( new CustomMembershipListeners( nodeName ) );
		disp.setRequestHandler(new CustomRequestHandler( nodeName ) );
	}

	public void start() throws Exception {
		for ( int i = 0; i < 100000; i++ ) {
			Util.sleep( 100 );
//			System.out.println( "Casting message #" + i );
			byte[] payload = ( "Number #" + i ).getBytes("utf8");
			RspList rsp_list = disp.castMessage( null,
					payload, 0, payload.length,
					RequestOptions.SYNC() );
//			System.out.println( "Responses:\n" + rsp_list );
		}
		Util.close( disp, channel );
	}

	public Object handle(Message msg) throws Exception {
//		System.out.println( "On node: " + nodeName + " handle(): " + msg );
		return "Success!";
	}

	private void connect() throws Exception {
		channel.connect( "MessageDispatcherTestGroup" );
	}

	public static void main(String[] args) {
		List<MessageDispatcherTest> nodes = IntStream.rangeClosed(1, 20)
				.parallel()
				.mapToObj( MessageDispatcherTest::startNode )
				.collect( Collectors.toList() );
	}

	private static MessageDispatcherTest startNode( int id) {
		MessageDispatcherTest node;
		try {
			node = new MessageDispatcherTest( id );
			node.connect();
			return node;
		} catch (Exception e) {
			throw new RuntimeException( e );
		}
	}

	static final class CustomRequestHandler implements RequestHandler {

		private final String nodeName;

		public CustomRequestHandler(String nodeName) {
			this.nodeName = nodeName;
		}

		@Override
		public Object handle(Message msg) throws Exception {
			System.out.println( "Node: " + nodeName +" Message: " + msg );
			return null;
		}

	}

	static final class CustomMembershipListeners implements MembershipListener {

		private final String nodeName;

		public CustomMembershipListeners(String nodeName) {
			this.nodeName = nodeName;
		}

		public void viewAccepted(View new_view) {
			System.out.println( "Node: " + nodeName +" New view: " + new_view );
		}

	}

}
