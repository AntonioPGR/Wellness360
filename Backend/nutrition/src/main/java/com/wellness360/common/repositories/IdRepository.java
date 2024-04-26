package com.wellness360.common.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public abstract interface IdRepository<Entity> extends JpaRepository<Entity, Integer> {
  
  Optional<Entity> findByUuid(String uuid);

  @Modifying
  void deleteByUuid(String uuid);

}
