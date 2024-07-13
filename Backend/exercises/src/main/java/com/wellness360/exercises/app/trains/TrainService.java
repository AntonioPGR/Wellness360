package com.wellness360.exercises.app.trains;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.exercises.ExerciseEntity;
import com.wellness360.exercises.app.trains.dtos.ExercisesSetsReturnDTO;
import com.wellness360.exercises.app.trains.dtos.TrainCreatePersistenceDTO;
import com.wellness360.exercises.app.trains.dtos.TrainCreateRequestDTO;
import com.wellness360.exercises.app.trains.dtos.TrainReturnDTO;
import com.wellness360.exercises.app.trains.dtos.TrainUpdatePersistenceDTO;
import com.wellness360.exercises.app.trains.dtos.TrainUpdateRequestDTO;
import com.wellness360.exercises.app.trains.sets.SetService;
import com.wellness360.exercises.packages.crud.service.CrudDtoTransformService;
import com.wellness360.exercises.tools.EntityRetriever;

@Service
public class TrainService extends CrudDtoTransformService<
  TrainRepository,
  TrainCreateRequestDTO,
  TrainCreatePersistenceDTO,
  TrainUpdateRequestDTO,
  TrainUpdatePersistenceDTO,
  TrainReturnDTO,
  TrainEntity
> {

  @Autowired
  SetService sets_service;
  @Autowired
  EntityRetriever entity_retriever;

  public TrainReturnDTO getReturnDTO(TrainEntity entity) {
    return new TrainReturnDTO(entity);
  }

  public TrainEntity getEntity(TrainCreatePersistenceDTO dto) {
    return new TrainEntity(dto);
  }

  public TrainCreatePersistenceDTO getPersistenceCreateDTO(TrainCreateRequestDTO request_dto) {
    List<ExerciseEntity> exercises = request_dto.getExercise_sets().stream().map(dto -> {
      return entity_retriever.getExerciseByUuid(dto.getExercise_uuid());
    }).toList();
    return new TrainCreatePersistenceDTO(request_dto, exercises);
  }

  public TrainUpdatePersistenceDTO getPersistenceUpdateDTO(TrainUpdateRequestDTO request_dto) {
    return new TrainUpdatePersistenceDTO(request_dto);
  }


  public TrainReturnDTO create(TrainCreateRequestDTO request_dto) {
    TrainReturnDTO return_dto = super.create(request_dto);

    TrainEntity train = entity_retriever.getTrainByUuid(return_dto.getUuid());
    List<ExercisesSetsReturnDTO> exercise_sets = sets_service.createAll(request_dto.getExercise_sets(), train);

    return_dto.setExercise_sets(exercise_sets);

    return return_dto;
  }

  @Override
  public void delete(String uuid) {
    sets_service.deleteAllWithExerciseUuid(uuid);
    super.delete(uuid);
  }


  
}
