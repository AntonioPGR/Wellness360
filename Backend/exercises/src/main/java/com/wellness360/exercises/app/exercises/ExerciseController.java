package com.wellness360.exercises.app.exercises;

import com.wellness360.exercises.app.exercises.dtos.ExerciseCreateRequestDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseReturnDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudStorageController;

public class ExerciseController extends CrudStorageController<
  ExerciseCreateRequestDTO,
  ExerciseUpdateRequestDTO,
  ExerciseReturnDTO,
  ExerciseService
> {
  
}
