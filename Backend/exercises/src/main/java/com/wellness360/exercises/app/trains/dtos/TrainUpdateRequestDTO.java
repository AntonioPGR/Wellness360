package com.wellness360.exercises.app.trains.dtos;

import java.util.List;

import com.wellness360.exercises.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainUpdateRequestDTO extends CrudUpdateRequestDTO {

  String uuid;
  String user_uuid;
  Integer week_day;
  String name;
  String description;

  List<ExercisesSetsCreateDTO> exercise_sets;

  public void validate(ValidateService validator) {
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

}
