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
package org.hibernate.search.jpa.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class FullTextProxyHandler implements InvocationHandler, Serializable {

	//These fields need special consideration for serialization: to be handled in subclasses!
	protected transient Object ormDelegate;
	protected transient Object fullTextDelegate;
	protected transient Set<Method> fullTextMethods;

	public FullTextProxyHandler(Object ormDelegate, Object fullTextDelegate, Set<Method> fullTextMethods) {
		this.ormDelegate = ormDelegate;
		this.fullTextDelegate = fullTextDelegate;
		this.fullTextMethods = fullTextMethods;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			if ( fullTextMethods.contains( method ) ) {
				return method.invoke( fullTextDelegate, args );
			}
			else {
				return method.invoke( ormDelegate, args );
			}
		}
//		catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		catch (InvocationTargetException e) {
			throw e.getCause();
		}
	}


}
