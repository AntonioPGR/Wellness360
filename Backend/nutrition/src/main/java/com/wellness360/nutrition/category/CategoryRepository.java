package com.wellness360.nutrition.category;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.wellness360.common.crud_default.CrudRepository;
import java.util.Optional;


@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer>{

  @Override
  @Query(value = "SELECT * FROM categories c WHERE c.uuid = ?1", nativeQuery = true)
  public Optional<CategoryEntity> findByUuid(String uuid);

  @Override
  @Modifying
  @Query(value = "DELETE FROM categories c WHERE c.uuid = ?1", nativeQuery = true)
  public void deleteByUuid(String uuid);

}
