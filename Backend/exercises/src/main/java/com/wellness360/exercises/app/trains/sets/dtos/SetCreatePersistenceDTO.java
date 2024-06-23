package com.wellness360.exercises.app.trains.sets.dtos;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.trains.TrainEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SetCreatePersistenceDTO{
  
  Short weight;
  Short reps;
  Short minutes;
  TrainEntity train;
  ExerciseEntity exercise;

  public SetCreatePersistenceDTO(SetCreateRequestDTO dto, TrainEntity train, ExerciseEntity exercise){
    this.weight = dto.weight.shortValue();
    this.reps = dto.reps.shortValue();
    this.minutes = dto.minutes.shortValue();
    this.train = train;
    this.exercise = exercise;
  }

}
