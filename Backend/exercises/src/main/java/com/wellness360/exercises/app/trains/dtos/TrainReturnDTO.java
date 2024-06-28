package com.wellness360.exercises.app.trains.dtos;

import java.util.Date;
import java.util.List;

import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.app.trains.sets.SetEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrainReturnDTO extends CrudReturnDTO{

  String uuid;
  String user_uuid;
  Integer week_day;
  String name;
  String description;
  Date created_at;
  Date updated_at;
  List<ExercisesSetsReturnDTO> exercise_sets;

  public TrainReturnDTO(TrainEntity entity) {
    uuid = entity.getUuid();
    user_uuid = entity.getUser_uuid();
    week_day = entity.getWeek_day().intValue();
    name = entity.getName();
    description = entity.getDescription();
    created_at = entity.getCreated_at();
    updated_at = entity.getUpdated_at();
    exercise_sets = entity.getExercises().stream().map((exercise)->{
      List<SetEntity> sets = entity.getSets().stream().filter((set)-> set.getExercise() == exercise).toList();
      return new ExercisesSetsReturnDTO(exercise.getUuid(), sets);
    }).toList();
  }

}