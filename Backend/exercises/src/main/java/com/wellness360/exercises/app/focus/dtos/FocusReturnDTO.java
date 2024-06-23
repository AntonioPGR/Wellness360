package com.wellness360.exercises.app.focus.dtos;

import com.wellness360.exercises.app.focus.FocusEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.exercises.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FocusReturnDTO extends CrudReturnDTO {
  
  String uuid;
  String body_muscle;
  Short priority;

  public FocusReturnDTO(FocusEntity entity) {
    this.uuid = entity.getUuid();
    this.body_muscle = entity.getBody_muscle();
    this.priority = entity.getPriority();
  }

  public void validate(ValidateService validator) {
    throw new UnsupportedOperationException("Unimplemented method 'validate'");
  }

}
