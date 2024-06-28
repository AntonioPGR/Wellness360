package com.wellness360.exercises.app.exercises;

import org.springframework.stereotype.Repository;

import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseEntity>{
  
}
