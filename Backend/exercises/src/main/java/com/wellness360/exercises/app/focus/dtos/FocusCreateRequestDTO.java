package com.wellness360.exercises.app.focus.dtos;

import com.wellness360.exercises.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FocusCreateRequestDTO extends CrudCreateRequestDTO {
  
  String body_part;
  Integer priority;
  String user_uuid;

  public void validate(ValidateService validator) {
    validator.validateBodyMuscle(body_part);
    validator.validatePriority(priority);
    validator.validateUuid(user_uuid);
  }

}
