package com.wellness360.exercises.app.exercises.muscles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.exercises.muscles.dtos.MuscleReturnDTO;

@Service
public class MuscleService {

  @Autowired
  MuscleRepository repository;

  public List<MuscleEntity> getByExercise(ExerciseEntity exercise) {
    return repository.findAllByExercise(exercise);
  }

  public MuscleReturnDTO save(String muscle, ExerciseEntity exercise) {
    MuscleEntity entity = new MuscleEntity(muscle, exercise);
    MuscleEntity saved_entity = repository.saveAndFlush(entity);
    return new MuscleReturnDTO(saved_entity);
  }

  public void deleteByExercise(ExerciseEntity exercise) {
    repository.deleteAllByExercise(exercise);
  }

}
