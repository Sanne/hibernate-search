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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

/**
 * @author Pragnesh
 */
@Entity
@Indexed
public class Company {
	@Id
	@GeneratedValue
	private int id;

	@Field(store = Store.YES)
	private String companyName;
	
	@IndexedEmbedded
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity=Companyfacility.class)
	private Set<Companyfacility> companyfacilities = new HashSet<Companyfacility>(
			0);

	public Company() {
	}

	public Company(String companyName) {
		this.companyName = companyName;
	}

	public int getId() {
		return id;
	}

	public String getMake() {
		return companyName;
	}
	

	public Set<Companyfacility> getCompanyfacilities()
	{
		return this.companyfacilities;
	}

	public void setCompanyfacilities(Set<Companyfacility> companyfacilities)
	{
		this.companyfacilities = companyfacilities;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append( "companyfacility" );
		sb.append( "{id=" ).append( id );
		sb.append( ", companyName='" ).append( companyName ).append( '\'' );
		sb.append( '}' );
		return sb.toString();
	}
}

