package com.wellness360.exercises.app.trains.dtos;

import java.util.List;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudCreatePersistenceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrainCreatePersistenceDTO extends CrudCreatePersistenceDTO {
  
  String user_uuid;
  Short week_day;
  String name;
  String description;
  List<ExerciseEntity> exercises;
  
  public TrainCreatePersistenceDTO(TrainCreateRequestDTO request_dto, List<ExerciseEntity> exercises) {
    user_uuid = request_dto.getUser_uuid();
    week_day = request_dto.getWeek_day().shortValue();
    name = request_dto.getName();
    description = request_dto.getDescription();
    this.exercises = exercises;
  }

}
