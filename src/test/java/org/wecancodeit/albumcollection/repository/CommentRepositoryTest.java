package org.wecancodeit.albumcollection.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.albumcollection.model.Comment;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
	
	@Resource
	CommentRepository commentRepo;
	
	@Test
	public void shouldContainComment() {
		Comment comment = commentRepo.save(new Comment());
		
		Iterable<Comment> result = commentRepo.findAll();
		
		assertThat(result, hasItems(comment));
		
	}
}