package org.wecancodeit.albumcollection.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.albumcollection.model.Song;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SongRepositoryTest {
	
	@Resource
	SongRepository songRepo;
	
	@Test
	public void shouldContainAlbum() {
		Song song = songRepo.save(new Song());
		
		Iterable<Song> result = songRepo.findAll();
		
		assertThat(result, hasItems(song));
		
	}
}