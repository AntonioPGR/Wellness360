package com.wellness360.exercises.app.focus.dtos;

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
public class FocusUpdateRequestDTO extends CrudUpdateRequestDTO {
  
  String uuid;
  String body_part;
  Integer priority;
  String user_uuid;

  public void validate(ValidateService validator) {
    validator.validateUuid(uuid);
    validator.validateBodyMuscle(body_part, true);
    validator.validatePriority(priority, true);
    validator.validateUuid(user_uuid, true);
  }

}
