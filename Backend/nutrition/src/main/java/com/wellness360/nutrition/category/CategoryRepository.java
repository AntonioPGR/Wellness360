package com.wellness360.nutrition.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{

  @Query(value = "SELECT * FROM categories c WHERE c.uuid = ?1", nativeQuery = true)
  public Optional<CategoryEntity> findByUuid(String uuid);

  @Modifying
  @Query(value = "DELETE FROM categories c WHERE c.uuid = ?1", nativeQuery = true)
  public void deleteByUuid(String uuid);

}
