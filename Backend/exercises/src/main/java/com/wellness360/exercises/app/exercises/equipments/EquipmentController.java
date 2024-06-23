package com.wellness360.exercises.app.exercises.equipments;

import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentCreateRequestDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentReturnDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.controllers.CrudStorageController;

public class EquipmentController extends CrudStorageController<
  EquipmentCreateRequestDTO,
  EquipmentUpdateRequestDTO,
  EquipmentReturnDTO,
  EquipmentService
> {
}
