package com.wellness360.exercises.app.injuries.dtos;

import java.util.Date;

import com.wellness360.exercises.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InjuryCreateRequestDTO extends CrudCreateRequestDTO {
  
  String body_part;
  String description;
  String user_uuid;
  Date initial_date;
  Date end_date;

  public void validate(ValidateService validator) {
    validator.validateBodyMuscle(body_part);
    validator.validateDescription(description, true);
    validator.validateUuid(user_uuid);
    validator.validateInitialDate(initial_date);
    validator.validateEndDate(end_date, initial_date);
  }

}
