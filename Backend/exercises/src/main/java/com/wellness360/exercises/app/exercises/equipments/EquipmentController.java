package com.wellness360.exercises.app.exercises.equipments;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentCreateRequestDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentReturnDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudStorageController;

@RestController
@RequestMapping("${path.equipments}")
public class EquipmentController extends CrudStorageController<
  EquipmentCreateRequestDTO,
  EquipmentUpdateRequestDTO,
  EquipmentReturnDTO,
  EquipmentService
> {
}
