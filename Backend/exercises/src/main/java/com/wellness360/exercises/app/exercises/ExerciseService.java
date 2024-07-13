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
import com.wellness360.exercises.app.exercises.muscles.MuscleService;
import com.wellness360.exercises.app.exercises.muscles.dtos.MuscleReturnDTO;
import com.wellness360.exercises.packages.storage.StorageService;
import com.wellness360.exercises.packages.storage.services.CrudStorageService;
import com.wellness360.exercises.packages.storage.settings.StorageFolders;
import com.wellness360.exercises.tools.EntityRetriever;

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
  MuscleService muscle_service;

  @Autowired
  StorageService storage_service;

  @Autowired
  EntityRetriever entity_retriever;

  public ExerciseReturnDTO getReturnDTO(ExerciseEntity entity) {
    List<MuscleEntity> muscles = muscle_service.getByExercise(entity);
    return new ExerciseReturnDTO(entity, muscles);
  }

  public ExerciseEntity getEntity(ExerciseCreatePersistenceDTO dto) {
    return new ExerciseEntity(dto);
  }

  public ExerciseCreatePersistenceDTO getPersistenceCreateDTO(ExerciseCreateRequestDTO request_dto, String file_name) {
    List<EquipmentEntity> equipments = request_dto.getEquipments_uuid().stream().map((uuid) -> entity_retriever.getEquipmentByUuid(uuid)).toList();
    String video_url = storage_service.store(request_dto.getVideo(), getFolderName(), request_dto.getName());
    return new ExerciseCreatePersistenceDTO(request_dto, file_name, video_url, equipments);
  }

  public ExerciseUpdatePersistenceDTO getPersistenceUpdateDTO(ExerciseUpdateRequestDTO request_dto, String file_name) {
    List<EquipmentEntity> equipments = null;
    if(request_dto.getEquipments_uuid() != null) equipments = request_dto.getEquipments_uuid().stream().map((uuid) -> entity_retriever.getEquipmentByUuid(uuid)).toList();
    String video_url = null;
    if(request_dto.getVideo() != null) video_url = storage_service.store(request_dto.getVideo(), getFolderName(), request_dto.getName());
    return new ExerciseUpdatePersistenceDTO(request_dto, file_name, video_url, equipments);
  }

  public String getFolderName() {
    return StorageFolders.exercises.name();
  }

  // OVERRIDES
  public ExerciseReturnDTO create(ExerciseCreateRequestDTO request_dto) {
    ExerciseReturnDTO return_dto = super.create(request_dto);
    ExerciseEntity exercise = entity_retriever.getExerciseByUuid(return_dto.getUuid());
    List<MuscleReturnDTO> muscles = request_dto.getMuscles().stream().map((muscle) -> muscle_service.save(muscle, exercise)).toList();
    return_dto.setMuscles(muscles);
    return return_dto;
  }

  public ExerciseReturnDTO update(ExerciseUpdateRequestDTO request_dto) {
    ExerciseReturnDTO return_dto = super.update(request_dto);
    return return_dto;
  }
  
  @Override
  public void delete(String uuid) {
    ExerciseEntity exercise = entity_retriever.getExerciseByUuid(uuid);
    muscle_service.deleteByExercise(exercise);
    super.delete(uuid);
  }
  
}
