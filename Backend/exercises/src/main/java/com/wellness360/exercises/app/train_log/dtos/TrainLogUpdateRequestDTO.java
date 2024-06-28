package com.wellness360.exercises.app.train_log.dtos;

import java.util.Date;
import java.util.List;

import com.wellness360.exercises.app.train_log.exercise.dtos.ExerciseLogCreateDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TrainLogUpdateRequestDTO extends CrudUpdateRequestDTO {
  
  String uuid;
  String user_uuid;
  Date date;
  Integer time;
  String train_uuid;
  List<ExerciseLogCreateDTO> exercise_sets;
  
  public void validate(ValidateService validator) {
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

}