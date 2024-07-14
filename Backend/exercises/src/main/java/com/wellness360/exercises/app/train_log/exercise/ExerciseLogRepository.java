package com.wellness360.exercises.app.train_log.exercise;

import org.springframework.stereotype.Repository;

import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface ExerciseLogRepository extends CrudRepository<ExerciseLogEntity> {
  
}
