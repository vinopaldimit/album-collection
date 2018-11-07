package org.wecancodeit.albumcollection.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.albumcollection.model.Tag;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TagRepositoryTest {
	
	@Resource
	TagRepository tagRepo;
	
	@Test
	public void shouldContainTag() {
		Tag tag = tagRepo.save(new Tag());
		
		Iterable<Tag> result = tagRepo.findAll();
		
		assertThat(result, hasItems(tag));
		
	}
}