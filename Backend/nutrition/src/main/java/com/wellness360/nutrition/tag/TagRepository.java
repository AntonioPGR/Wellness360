package com.wellness360.nutrition.tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellness360.common.repositories.IdRepository;

@Repository
public interface TagRepository extends IdRepository<TagEntity> {

  @Query(value = "SELECT * FROM tags t WHERE t.category_id = ?1", nativeQuery = true)
  Page<TagEntity> findAllByCategoryUuid(Integer category_id, Pageable pageable);

}
