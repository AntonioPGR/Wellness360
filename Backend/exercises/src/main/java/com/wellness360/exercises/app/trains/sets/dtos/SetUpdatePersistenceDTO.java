package com.wellness360.exercises.app.trains.sets.dtos;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.enums.CategoriesEnum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SetUpdatePersistenceDTO{
  
  String uuid;
  Short weight;
  Short reps;
  Short minutes;
  CategoriesEnum category;
  TrainEntity train;
  ExerciseEntity exercise;

  public SetUpdatePersistenceDTO(SetUpdateRequestDTO dto, TrainEntity train, ExerciseEntity exercise){
    this.uuid = dto.getUuid();
    weight = dto.getWeight() != null? dto.getWeight().shortValue() : null;
    reps = dto.getReps() != null? dto.getReps().shortValue() : null;
    minutes = dto.getMinutes() != null? dto.getMinutes().shortValue() : null;
    this.train = train;
    this.exercise = exercise;
  }

}
