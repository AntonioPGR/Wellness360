package com.wellness360.exercises.app.trains.sets.dtos;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.trains.TrainEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SetCreatePersistenceDTO{
  
  Short weight;
  Short reps;
  Short minutes;
  TrainEntity train;
  ExerciseEntity exercise;

  public SetCreatePersistenceDTO(SetCreateRequestDTO dto, TrainEntity train, ExerciseEntity exercise){
    this.weight = dto.weight != null? dto.weight.shortValue() : null;
    this.reps = dto.reps != null? dto.reps.shortValue() : null;
    this.minutes = dto.minutes != null? dto.minutes.shortValue() : null;
    this.train = train;
    this.exercise = exercise;
  }

}
