/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2013, Red Hat, Inc. and/or its affiliates or third-party contributors as
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
package org.hibernate.search.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.search.jpa.impl.FullTextProxyHandler;

public final class FullTextSessionProxyHandler extends FullTextProxyHandler implements InvocationHandler, Serializable {

	private static Set<Method> FULL_TEXT_METHODS = initializeFullTextMethodsSet();

	public FullTextSessionProxyHandler(Session session) {
		super( session, new FullTextSessionImpl( session ), FULL_TEXT_METHODS );
	}

	private static Set<Method> initializeFullTextMethodsSet() {
		HashSet<Method> fteMethods = new HashSet<Method>();
		for ( Method m : SessionContractOverrides.class.getMethods() ) {
			fteMethods.add( m );
		}
		return Collections.unmodifiableSet( fteMethods );
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeObject( this.ormDelegate );
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		Session originalSession = (Session) in.readObject();
		this.ormDelegate = originalSession;
		this.fullTextDelegate = new FullTextSessionImpl( originalSession );
		this.fullTextMethods = FULL_TEXT_METHODS;
	}

}
