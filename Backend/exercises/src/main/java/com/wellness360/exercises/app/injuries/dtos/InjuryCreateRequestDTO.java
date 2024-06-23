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
  
  String body_muscle;
  String description;
  Date initial_date;
  Date end_date;
  String user_uuid;

  public void validate(ValidateService validator) {
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

}
