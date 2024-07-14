package com.wellness360.exercises.app.train_log;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.exercises.app.train_log.dtos.TrainLogCreateRequestDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogReturnDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudController;

@RestController
@RequestMapping("${path.logs}")
public class TrainLogController extends CrudController<
  TrainLogCreateRequestDTO,
  TrainLogUpdateRequestDTO,
  TrainLogReturnDTO,
  TrainLogService
> {
}
