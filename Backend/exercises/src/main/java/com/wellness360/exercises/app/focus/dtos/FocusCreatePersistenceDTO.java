package com.wellness360.exercises.app.focus.dtos;

import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.dtos.CrudCreatePersistenceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FocusCreatePersistenceDTO extends CrudCreatePersistenceDTO {
  
  BodyMusclesEnum body_muscle;
  Short priority;
  String user_uuid;

  public FocusCreatePersistenceDTO(FocusCreateRequestDTO request_dto, BodyMusclesEnum body_muscle) {
    this.body_muscle = body_muscle;
    this.priority = request_dto.getPriority().shortValue();
    this.user_uuid = request_dto.getUser_uuid();
  }

}
