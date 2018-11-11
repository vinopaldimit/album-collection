package org.wecancodeit.albumcollection.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.albumcollection.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByTagNameIgnoreCase(String newTag);

}