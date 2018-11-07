package org.wecancodeit.albumcollection.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.albumcollection.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}