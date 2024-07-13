package com.wellness360.exercises.app.exercises.muscles;

import java.util.List;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.packages.crud.repositories.CrudRepository;

public interface MuscleRepository extends CrudRepository<MuscleEntity> {

  List<MuscleEntity> findAllByExercise(ExerciseEntity exercise);

  void deleteAllByExercise(ExerciseEntity exercise);
  
}
