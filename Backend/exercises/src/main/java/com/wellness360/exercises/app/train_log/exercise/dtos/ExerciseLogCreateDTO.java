package com.wellness360.exercises.app.train_log.exercise.dtos;

import java.util.List;

import com.wellness360.exercises.app.train_log.sets.dtos.SetsLogCreateDTO;

public class ExerciseLogCreateDTO {

  String exercise_uuid;
  List<SetsLogCreateDTO> sets;

}
