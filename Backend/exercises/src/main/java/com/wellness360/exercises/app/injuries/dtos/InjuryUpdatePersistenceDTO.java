package com.wellness360.exercises.app.injuries.dtos;

import java.util.Date;

import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdatePersistenceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InjuryUpdatePersistenceDTO extends CrudUpdatePersistenceDTO {
  
  String uuid;
  BodyMusclesEnum body_part;
  String description;
  Date initial_date;
  Date end_date;
  String user_uuid;

  public InjuryUpdatePersistenceDTO(InjuryUpdateRequestDTO request_dto, BodyMusclesEnum body_part) {
    this.uuid = request_dto.uuid;
    this.body_part = body_part;
    this.description = request_dto.getDescription();
    this.initial_date = request_dto.getInitial_date();
    this.end_date = request_dto.getEnd_date();
    this.user_uuid = request_dto.getUser_uuid();
  }

}
