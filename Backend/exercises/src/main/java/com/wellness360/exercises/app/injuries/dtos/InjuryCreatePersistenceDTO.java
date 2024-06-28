package com.wellness360.exercises.app.injuries.dtos;

import java.util.Date;

import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.dtos.CrudCreatePersistenceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InjuryCreatePersistenceDTO extends CrudCreatePersistenceDTO {
  
  BodyMusclesEnum body_part;
  String description;
  Date initial_date;
  Date end_date;
  String user_uuid;
  
  public InjuryCreatePersistenceDTO(InjuryCreateRequestDTO request_dto, BodyMusclesEnum body_part) {
    this.body_part = body_part;
    this.description = request_dto.getDescription();
    this.initial_date = request_dto.getInitial_date();
    this.end_date = request_dto.getEnd_date();
    this.user_uuid = request_dto.getUser_uuid();
  }

}
