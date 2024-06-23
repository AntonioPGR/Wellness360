package com.wellness360.exercises.app.trains.dtos;

import com.wellness360.exercises.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainUpdatePersistenceDTO extends CrudUpdatePersistenceDTO {
  
  String uuid;
  String user_uuid;
  Short week_day;
  String name;
  String description;
  
  public TrainUpdatePersistenceDTO(TrainUpdateRequestDTO request_dto) {
    uuid = request_dto.getUuid();
    user_uuid = request_dto.getUser_uuid();
    week_day = request_dto.getWeek_day().shortValue();
    name = request_dto.getName();
    description = request_dto.getDescription();
  }

}
