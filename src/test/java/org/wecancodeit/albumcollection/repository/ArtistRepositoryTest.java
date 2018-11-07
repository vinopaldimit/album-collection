package org.wecancodeit.albumcollection.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.albumcollection.model.Artist;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArtistRepositoryTest {
	
	@Resource
	ArtistRepository artistRepo;
	
	@Test
	public void shouldContainArtist() {
		Artist artist = artistRepo.save(new Artist());
		
		Iterable<Artist> result = artistRepo.findAll();
		
		assertThat(result, hasItems(artist));
		
	}
}