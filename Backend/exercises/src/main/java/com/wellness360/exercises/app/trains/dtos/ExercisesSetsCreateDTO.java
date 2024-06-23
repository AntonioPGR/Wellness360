package com.wellness360.exercises.app.trains.dtos;

import java.util.List;

import com.wellness360.exercises.app.trains.sets.dtos.SetCreateRequestDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ExercisesSetsCreateDTO {

  String exercise_uuid;
  List<SetCreateRequestDTO> sets;
  
}
