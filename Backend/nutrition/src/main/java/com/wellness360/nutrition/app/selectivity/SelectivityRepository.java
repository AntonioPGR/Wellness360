package com.wellness360.nutrition.app.selectivity;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;

@NoRepositoryBean
public abstract interface SelectivityRepository<Entity> extends CrudRepository<Entity> {
  List<Entity> findAllByUserUuid(String uuid);
}