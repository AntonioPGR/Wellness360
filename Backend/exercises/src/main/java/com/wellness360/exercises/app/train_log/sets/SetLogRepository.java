package com.wellness360.exercises.app.train_log.sets;

import org.springframework.stereotype.Repository;

import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface SetLogRepository extends CrudRepository<SetLogEntity> {
  
}
