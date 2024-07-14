package com.wellness360.exercises.app.train_log.dtos;

import java.util.Date;
import java.util.List;

import com.wellness360.exercises.app.train_log.exercise.dtos.ExerciseLogCreateDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainLogCreateRequestDTO extends CrudCreateRequestDTO {

  String user_uuid;
  Date date;
  Integer time;
  String train_uuid;
  List<ExerciseLogCreateDTO> exercise_sets;

  public void validate(ValidateService validator) {
    validator.validateUuid(user_uuid);
    validator.validatePastDate(date);
    validator.validateShort(time);
    validator.validateUuid(train_uuid);
    exercise_sets.forEach(exercise -> exercise.validate(validator));
  }
  
}
