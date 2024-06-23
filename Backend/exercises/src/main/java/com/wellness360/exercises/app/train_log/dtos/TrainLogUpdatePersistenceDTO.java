package com.wellness360.exercises.app.train_log.dtos;

import java.util.Date;

import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainLogUpdatePersistenceDTO extends CrudUpdatePersistenceDTO {
  
  String uuid;
  String user_uuid;
  Date date;
  Short time;
  TrainEntity train;

  public TrainLogUpdatePersistenceDTO(TrainLogUpdateRequestDTO request_dto, TrainEntity train) {
    uuid = request_dto.getUuid();
    user_uuid = request_dto.getUser_uuid();
    date = request_dto.getDate();
    time = request_dto.getTime().shortValue();
    this.train = train;
  }
  
}
