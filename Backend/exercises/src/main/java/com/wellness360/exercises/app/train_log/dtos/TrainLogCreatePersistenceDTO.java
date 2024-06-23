package com.wellness360.exercises.app.train_log.dtos;

import java.util.Date;

import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudCreatePersistenceDTO;

import lombok.Getter;

@Getter
public class TrainLogCreatePersistenceDTO extends CrudCreatePersistenceDTO {
  
  String user_uuid;
  Date date;
  Short time;
  TrainEntity train;
  
  public TrainLogCreatePersistenceDTO(TrainLogCreateRequestDTO request_dto, TrainEntity train) {
    user_uuid = request_dto.getUser_uuid();
    date = request_dto.getDate();
    time = request_dto.getTime().shortValue();
    this.train = train;
  }

}
