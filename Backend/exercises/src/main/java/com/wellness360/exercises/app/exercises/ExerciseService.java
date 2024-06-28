package com.wellness360.exercises.app.exercises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.exercises.dtos.ExerciseCreatePersistenceDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseCreateRequestDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseReturnDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseUpdatePersistenceDTO;
import com.wellness360.exercises.app.exercises.dtos.ExerciseUpdateRequestDTO;
import com.wellness360.exercises.app.exercises.equipments.EquipmentEntity;
import com.wellness360.exercises.app.exercises.muscles.MuscleEntity;
import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.storage.StorageService;
import com.wellness360.exercises.packages.storage.services.CrudStorageService;
import com.wellness360.exercises.packages.storage.settings.StorageFolders;
import com.wellness360.exercises.tools.EntityRetriever;

import jakarta.validation.ValidationException;

@Service
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
  @Autowired
  StorageService storage_service;

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
    String video_url = storage_service.store(request_dto.getVideo(), StorageFolders.exercises.name(), request_dto.getName());
    return new ExerciseCreatePersistenceDTO(request_dto, file_name, video_url, muscles, equipments);
  }

  public ExerciseUpdatePersistenceDTO getPersistenceUpdateDTO(ExerciseUpdateRequestDTO request_dto, String file_name) {
    List<String> equipments_uuid = request_dto.getEquipments_uuid();
    List<EquipmentEntity> equipments = equipments_uuid != null? equipments_uuid.stream().map((uuid) -> entity_retriever.getEquipmentByUuid(uuid)).toList() : null;

    List<String> muscles_labels = request_dto.getEquipments_uuid();
    List<MuscleEntity>  muscles = muscles_labels != null? request_dto.getMuscles().stream().map((muscle) -> new MuscleEntity(BodyMusclesEnum.valueOf(muscle.toUpperCase()))).toList() : null;

    String video_url = null;
    if(request_dto.getVideo() != null){
      ExerciseEntity entity = entity_retriever.getExerciseByUuid(request_dto.getUuid());
      video_url = storage_service.update(request_dto.getVideo(), entity.getVideo_url());
    }

    return new ExerciseUpdatePersistenceDTO(request_dto, file_name, video_url, muscles, equipments);
  }
  
  // Overrides
  @Override
  public ExerciseReturnDTO create(ExerciseCreateRequestDTO request_dto){
    ExerciseReturnDTO return_dto = super.create(request_dto);
    // String uuid = return_dto.getUuid();
    // String file_name = return_dto.getVideo_url();

    // store_service.delete(file_name);
    // String uuid_file_name = store_service.store(request_dto.getFile(), getFolderName(), uuid);
    // ExerciseEntity entity = entity_retriever.getExerciseByUuid(uuid);
    // entity.setVideo_url(uuid_file_name);
    // entity = saveEntity(entity);
    return return_dto;
  }

  @Override
  public void delete(String uuid){
    ExerciseEntity entity = entity_retriever.getExerciseByUuid(uuid);
    try{ store_service.delete(entity.getVideo_url()); } catch (ValidationException e) {}
    super.delete(uuid);
  }

}
