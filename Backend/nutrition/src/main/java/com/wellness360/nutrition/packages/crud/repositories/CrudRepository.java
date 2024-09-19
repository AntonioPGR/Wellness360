package com.wellness360.nutrition.packages.crud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract interface CrudRepository<Entity> extends JpaRepository<Entity, Integer> {
  
  Optional<Entity> findByUuid(String uuid);

  @Modifying
  void deleteByUuid(String uuid);

}
