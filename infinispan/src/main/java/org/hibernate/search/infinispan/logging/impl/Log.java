/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.infinispan.logging.impl;

import static org.jboss.logging.Logger.Level.DEBUG;
import static org.jboss.logging.Logger.Level.ERROR;
import static org.jboss.logging.Logger.Level.WARN;

import javax.naming.NamingException;

import org.hibernate.search.exception.SearchException;
import org.infinispan.remoting.transport.Address;
import org.infinispan.remoting.transport.jgroups.SuspectException;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;

/**
 * Hibernate Search Infinispan's log abstraction layer on top of JBoss Logging.
 *
 * @author Davide D'Alto
 * @since 4.0
 */
@MessageLogger(projectCode = "HSEARCH")
public interface Log extends org.hibernate.search.util.logging.impl.Log {

	@LogMessage(level = ERROR)
	@Message(id = 100055, value = "Unable to retrieve CacheManager from JNDI [%s]")
	void unableToRetrieveCacheManagerFromJndi(String jndiNamespace, @Cause NamingException ne);

	@LogMessage(level = ERROR)
	@Message(id = 100056, value = "Unable to release initial context")
	void unableToReleaseInitialContext(@Cause NamingException ne);

	@Message(id = 100057, value = "Received am Infinispan custom command with unknown id '%1$b'")
	SearchException unknownInfinispanCommandId(byte commandId);

	@LogMessage(level = DEBUG)
	@Message(id = 100058, value = "Apply LuceneWork %s delegating to local indexing engine")
	void applyingChangeListLocally(Object workList);

	@LogMessage(level = DEBUG)
	@Message(id = 100059, value = "Going to ship LuceneWork %s to a remote master indexer")
	void applyingChangeListRemotely(Object workList);

	@LogMessage(level = WARN)
	@Message(id = 100060, value = "Index named '%1$s' is ignoring configuration option 'directory_provider' set to '%2$s':"
			+ " overriden to use the Infinispan Directory")
	void ignoreDirectoryProviderProperty(String indexName, String directoryOption);

	@LogMessage(level = DEBUG)
	@Message(id = 100061, value = "Sent list of LuceneWork %s to node %s")
	void workListRemotedTo(Object workList, Address primaryNodeAddress);

	@LogMessage(level = ERROR)
	@Message(id = 100062, value = "Collision on active IndexManagers named '%s' on the same Infinispan CacheManager!")
	void replacingRegisteredIndexManager(String name);

	@LogMessage(level = WARN)
	@Message(id = 100063, value = "Received remote command for index '%s' but the related IndexManager is either"
			+ " not yet fully started or unknown. Index might be out of sync!")
	void messageForUnknownIndexManager(String indexName);

	@Message(id = 100064, value = "Cache named '%s' needs to be configured with either transactions or batching enabled")
	SearchException batchRequiredOnCache(String cacheName);

	@Message(id = 100065, value = "Exceeded allowed retry attempts '%1$d' on remoting of an indexing command. Critical network issues?")
	SearchException tooManySuspectExceptionsOnWorkRemoting(@Cause SuspectException se, int maxRetryAttempts);

	@Message(id = 100066, value = "Remote indexing operations cancelled: thread interrupted.")
	SearchException interruptedDuringRemoting();

}
