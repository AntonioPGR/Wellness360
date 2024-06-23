package com.wellness360.exercises.app.exercises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.exercises.app.exercises.dtos.ExerciseCreatePersistenceDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseCreateRequestDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseReturnDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseUpdatePersistenceDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseUpdateRequestDTO;
import com.wellness360.exercises.app.exercises.equipments.EquipmentEntity;
import com.wellness360.exercises.app.exercises.muscles.MuscleEntity;
import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.storage.services.CrudStorageService;
import com.wellness360.exercises.packages.storage.settings.StorageFolders;
import com.wellness360.exercises.tools.EntityRetriever;

public class ExerciseService extends CrudStorageService<
  ExerciseRepository,
  ExerciseCreateRequestDTO,
  ExerciseCreatePersistenceDTO,
  ExerciseUpdateRequestDTO,
  ExerciseUpdatePersistenceDTO,
  ExerciseReturnDTO,
  ExerciseEntity
> {

  @Autowired
  EntityRetriever entity_retriever;

  public String getFolderName() {
    return StorageFolders.exercises.name();
  }

  public ExerciseReturnDTO getReturnDTO(ExerciseEntity entity) {
    return new ExerciseReturnDTO(entity);
  }

  public ExerciseEntity getEntity(ExerciseCreatePersistenceDTO dto) {
    return new ExerciseEntity(dto);
  }

  public ExerciseCreatePersistenceDTO getPersistenceCreateDTO(ExerciseCreateRequestDTO request_dto, String file_name) {
    List<EquipmentEntity> equipments = request_dto.getEquipments_uuid().stream().map((uuid) -> entity_retriever.getEquipmentByUuid(uuid)).toList();
    List<MuscleEntity>  muscles = request_dto.getMuscles().stream().map((muscle) -> new MuscleEntity(BodyMusclesEnum.valueOf(muscle.toUpperCase()))).toList();
    return new ExerciseCreatePersistenceDTO(request_dto, file_name, muscles, equipments);
  }

  public ExerciseUpdatePersistenceDTO getPersistenceUpdateDTO(ExerciseUpdateRequestDTO request_dto, String file_name) {
    List<String> equipments_uuid = request_dto.getEquipments_uuid();
    List<EquipmentEntity> equipments = equipments_uuid != null? equipments_uuid.stream().map((uuid) -> entity_retriever.getEquipmentByUuid(uuid)).toList() : null;

    List<String> muscles_labels = request_dto.getEquipments_uuid();
    List<MuscleEntity>  muscles = muscles_labels != null? request_dto.getMuscles().stream().map((muscle) -> new MuscleEntity(BodyMusclesEnum.valueOf(muscle.toUpperCase()))).toList() : null;

    return new ExerciseUpdatePersistenceDTO(request_dto, file_name, muscles, equipments);
  }
  
}
