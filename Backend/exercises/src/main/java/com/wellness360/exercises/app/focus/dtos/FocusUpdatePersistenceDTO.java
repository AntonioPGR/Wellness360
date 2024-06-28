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
  BodyMusclesEnum body_part;
  Short priority;
  String user_uuid;
  
  public FocusUpdatePersistenceDTO(FocusUpdateRequestDTO request_dto, BodyMusclesEnum body_muscle, Short priority) {
    this.uuid = request_dto.uuid;
    this.body_part = body_muscle;
    this.priority = priority;
    this.user_uuid = request_dto.user_uuid;
  }

}
