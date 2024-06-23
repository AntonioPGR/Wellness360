package com.wellness360.exercises.app.train_log.exercise.dtos;

import java.util.List;

import com.wellness360.exercises.app.train_log.exercise.ExerciseLogEntity;
import com.wellness360.exercises.app.train_log.sets.dtos.SetsLogReturnDTO;

import lombok.Getter;

@Getter
public class ExerciseLogReturnDTO {

  String exercise_uuid;
  List<SetsLogReturnDTO> sets;

  public ExerciseLogReturnDTO(ExerciseLogEntity exercise_log) {
    exercise_uuid = exercise_log.getExercise().getUuid();
    sets = exercise_log.getSet_logs().stream().map((set) -> new SetsLogReturnDTO(set)).toList();
  }

}
