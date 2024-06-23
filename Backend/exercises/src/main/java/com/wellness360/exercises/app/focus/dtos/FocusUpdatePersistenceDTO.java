package com.wellness360.exercises.app.focus.dtos;

import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FocusUpdatePersistenceDTO extends CrudUpdatePersistenceDTO {

  String uuid;
  BodyMusclesEnum body_muscle;
  short priority;
  String user_uuid;
  
  public FocusUpdatePersistenceDTO(FocusUpdateRequestDTO request_dto, BodyMusclesEnum body_muscle) {
    this.uuid = request_dto.uuid;
    this.body_muscle = body_muscle;
    this.priority = request_dto.getPriority().shortValue();
    this.user_uuid = request_dto.user_uuid;
  }

}
