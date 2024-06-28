package com.wellness360.exercises.app.exercises;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.exercises.app.exercises.dtos.ExerciseCreateRequestDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseReturnDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudStorageController;

@RestController
@RequestMapping("${path.exercises}")
public class ExerciseController extends CrudStorageController<
  ExerciseCreateRequestDTO,
  ExerciseUpdateRequestDTO,
  ExerciseReturnDTO,
  ExerciseService
> {
  
}
