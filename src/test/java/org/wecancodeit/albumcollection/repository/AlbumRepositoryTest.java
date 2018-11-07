package org.wecancodeit.albumcollection.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.albumcollection.model.Album;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTest {
	
	@Resource
	AlbumRepository albumRepo;
	
	@Test
	public void shouldContainAlbum() {
		Album album = albumRepo.save(new Album());
		
		Iterable<Album> result = albumRepo.findAll();
		
		assertThat(result, hasItems(album));
		
	}
}
