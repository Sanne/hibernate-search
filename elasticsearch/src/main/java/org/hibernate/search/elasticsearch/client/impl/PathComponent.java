/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.elasticsearch.client.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.hibernate.search.exception.AssertionFailure;

public final class PathComponent {

	public static final String PATH_SEPARATOR = "/";

	public final String encodedPath;
	public final String original;

	private PathComponent(String string) {
		this.original = string;
		try {
			encodedPath = URLEncoder.encode( string, StandardCharsets.UTF_8.name() );
		}
		catch (UnsupportedEncodingException e) {
			throw new AssertionFailure( "Unexpected error retrieving the UTF-8 charset", e );
		}
	}

	/**
	 * @param string
	 * @return
	 */
	public static PathComponent fromString(String string) {
		Objects.requireNonNull( string );
		return new PathComponent( string );
	}

	@Override
	public String toString() {
		return original;
	}

	@Override
	public int hashCode() {
		return original.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( PathComponent.class != obj.getClass() )
			return false;
		PathComponent other = (PathComponent) obj;
		return original.equals( other.original );
	}

}
