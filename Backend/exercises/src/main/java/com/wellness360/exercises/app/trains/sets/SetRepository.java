package com.wellness360.exercises.app.trains.sets;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

@Repository
public interface SetRepository extends CrudRepository<SetEntity> {

  List<SetEntity> deleteAllByExercise(ExerciseEntity exercise);
  
}
