package com.wellness360.exercises.app.train_log;

import com.wellness360.exercises.app.train_log.dtos.TrainLogCreateRequestDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogReturnDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudController;

public class TrainLogController extends CrudController<
  TrainLogCreateRequestDTO,
  TrainLogUpdateRequestDTO,
  TrainLogReturnDTO,
  TrainLogService
> {
}
