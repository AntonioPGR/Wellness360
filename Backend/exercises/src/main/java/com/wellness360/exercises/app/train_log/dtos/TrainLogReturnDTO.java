package com.wellness360.exercises.app.train_log.dtos;

import java.util.Date;
import java.util.List;

import com.wellness360.exercises.app.train_log.TrainLogEntity;
import com.wellness360.exercises.app.train_log.exercise.dtos.ExerciseLogReturnDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;
import lombok.Getter;

@Getter
public class TrainLogReturnDTO extends CrudReturnDTO{
  
  String uuid;
  String user_uuid;
  Date date;
  Integer time;
  String train_uuid;
  List<ExerciseLogReturnDTO> exercise_sets;
  
  public TrainLogReturnDTO(TrainLogEntity entity) {
    uuid = entity.getUuid();
    user_uuid = entity.getUser_uuid();
    date = entity.getDate();
    time = entity.getTime_spent().intValue();
    train_uuid = entity.getTrain().getUuid();
    exercise_sets = entity.getExercises_logs().stream().map((exercise) -> new ExerciseLogReturnDTO(exercise)).toList();
  }
  
}
