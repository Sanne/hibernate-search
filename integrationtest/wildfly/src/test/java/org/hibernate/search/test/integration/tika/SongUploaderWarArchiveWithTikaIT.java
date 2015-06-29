/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.test.integration.tika;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.inject.Inject;

import org.hibernate.search.test.integration.VersionTestHelper;
import org.hibernate.search.test.integration.tika.controller.SongUploader;
import org.hibernate.search.test.integration.tika.model.Mp3TikaMetadataProcessor;
import org.hibernate.search.test.integration.tika.model.Song;
import org.hibernate.search.test.integration.tika.util.Resources;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.persistence20.PersistenceDescriptor;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Example of an integration test using JBoss AS 7 and Arquillian.
 *
 * @author Davide D'Alto
 */
@RunWith(Arquillian.class)
public class SongUploaderWarArchiveWithTikaIT {

	@Deployment
	public static Archive<?> createTestArchive() {
		WebArchive war = ShrinkWrap
				.create( WebArchive.class, SongUploaderWarArchiveWithTikaIT.class.getSimpleName() + ".war" )
				.addClasses( SongUploaderWarArchiveWithTikaIT.class, Song.class, SongUploader.class, Resources.class, Mp3TikaMetadataProcessor.class )
				.addAsResource( persistenceXml(), "META-INF/persistence.xml" )
				.addAsResource( VersionTestHelper.moduleDependencyManifest(), "META-INF/MANIFEST.MF" )
				.addAsLibraries( tikaLibraries() )
				.addAsWebInfResource( EmptyAsset.INSTANCE, "beans.xml" )
				;
		return war;
	}

	private static JavaArchive[] tikaLibraries() {
		JavaArchive[] tikaLibraries = Maven	
				.resolver()
				.resolve( "org.apache.tika:tika-core:" + VersionTestHelper.getDependencyVersionTika(), "org.apache.tika:tika-parsers:" + VersionTestHelper.getDependencyVersionTika() )
						.withoutTransitivity()
						.as( JavaArchive.class );

		return tikaLibraries;
	}

	private static Asset persistenceXml() {
		String persistenceXml = Descriptors.create( PersistenceDescriptor.class )
			.version( "2.0" )
			.createPersistenceUnit()
				.name( "primary" )
				.jtaDataSource( "java:jboss/datasources/ExampleDS" )
				.getOrCreateProperties()
					.createProperty().name( "hibernate.hbm2ddl.auto" ).value( "create-drop" ).up()
					.createProperty().name( "hibernate.search.default.lucene_version" ).value( "LUCENE_CURRENT" ).up()
					.createProperty().name( "hibernate.search.default.directory_provider" ).value( "ram" ).up()
				.up().up()
			.exportAsString();
		return new StringAsset( persistenceXml );
	}

	@Inject
	SongUploader songUploader;

	@Test
	public void testSongUpload() throws Exception {
		Song newSong = songUploader.getNewSong();
		newSong.setMp3FileName( "/home/sanne/workspaces/hibernate/hibernate-search-root/integrationtest/wildfly/src/test/resources/org/hibernate/search/test/bridge/tika/mysong.mp3" );
		songUploader.upload();

		assertNotNull( newSong.getId() );
	}
}
