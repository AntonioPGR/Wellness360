package com.wellness360.common.crud_default;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public abstract interface CrudRepository<Entity, IdType> extends JpaRepository<Entity, Integer> {
  
  Optional<Entity> findByUuid(String uuid);

  @Modifying
  void deleteByUuid(String uuid);

}
