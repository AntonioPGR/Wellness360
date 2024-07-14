package com.wellness360.exercises.app.trains;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.exercises.app.trains.dtos.TrainCreateRequestDTO;
import com.wellness360.exercises.app.trains.dtos.TrainReturnDTO;
import com.wellness360.exercises.app.trains.dtos.TrainUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudController;

@RestController
@RequestMapping("${path.train}")
public class TrainController extends CrudController<
  TrainCreateRequestDTO,
  TrainUpdateRequestDTO,
  TrainReturnDTO,
  TrainService
>{
}
