package com.wellness360.nutrition.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tags")
public interface TagRepository extends JpaRepository<TagEntity, Integer> {
}
