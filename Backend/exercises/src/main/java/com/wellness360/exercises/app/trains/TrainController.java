package com.wellness360.exercises.app.trains;

import com.wellness360.exercises.app.trains.dtos.TrainCreateRequestDTO;
import com.wellness360.exercises.app.trains.dtos.TrainReturnDTO;
import com.wellness360.exercises.app.trains.dtos.TrainUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudController;

public class TrainController extends CrudController<
  TrainCreateRequestDTO,
  TrainUpdateRequestDTO,
  TrainReturnDTO,
  TrainService
>{
}
