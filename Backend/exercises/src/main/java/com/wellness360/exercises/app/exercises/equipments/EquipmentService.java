package com.wellness360.exercises.app.exercises.equipments;

import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentCreatePersistenceDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentCreateRequestDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentReturnDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentUpdatePersistenceDTO;
import com.wellness360.exercises.app.exercises.equipments.dtos.EquipmentUpdateRequestDTO;
import com.wellness360.exercises.packages.storage.services.CrudStorageService;
import com.wellness360.exercises.packages.storage.settings.StorageFolders;


public class EquipmentService extends CrudStorageService<
  EquipmentRepository,
  EquipmentCreateRequestDTO,
  EquipmentCreatePersistenceDTO,
  EquipmentUpdateRequestDTO,
  EquipmentUpdatePersistenceDTO,
  EquipmentReturnDTO,
  EquipmentEntity
> {

  public EquipmentReturnDTO getReturnDTO(EquipmentEntity entity) {
    return new EquipmentReturnDTO(entity);
  }

  public EquipmentEntity getEntity(EquipmentCreatePersistenceDTO dto) {
    return new EquipmentEntity(dto);
  }

  public EquipmentCreatePersistenceDTO getPersistenceCreateDTO(EquipmentCreateRequestDTO request_dto, String image_url) {
    return new EquipmentCreatePersistenceDTO(request_dto, image_url);
  }

  public EquipmentUpdatePersistenceDTO getPersistenceUpdateDTO(EquipmentUpdateRequestDTO request_dto, String image_url) {
    return new EquipmentUpdatePersistenceDTO(request_dto, image_url);
  }

  public String getFolderName() {
    return StorageFolders.equipment.name();
  }

  
  
}
