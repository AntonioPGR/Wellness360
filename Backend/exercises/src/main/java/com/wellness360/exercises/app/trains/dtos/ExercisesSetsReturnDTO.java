package com.wellness360.exercises.app.trains.dtos;

import java.util.List;

import com.wellness360.exercises.app.trains.sets.SetEntity;
import com.wellness360.exercises.app.trains.sets.dtos.SetReturnDTO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExercisesSetsReturnDTO {

  String exercise_uuid;
  List<SetReturnDTO> sets;
  
  public ExercisesSetsReturnDTO(String exercise_uuid, List<SetEntity> sets) {
    this.exercise_uuid = exercise_uuid;
    this.sets = sets.stream().map((set) -> new SetReturnDTO(set)).toList();
  }
  
}
