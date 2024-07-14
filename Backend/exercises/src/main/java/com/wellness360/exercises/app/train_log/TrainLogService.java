package com.wellness360.exercises.app.train_log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.train_log.dtos.TrainLogCreatePersistenceDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogCreateRequestDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogReturnDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogUpdatePersistenceDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogUpdateRequestDTO;
import com.wellness360.exercises.app.train_log.exercise.ExerciseLogService;
import com.wellness360.exercises.app.train_log.exercise.dtos.ExerciseLogReturnDTO;
import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.packages.crud.service.CrudDtoTransformService;
import com.wellness360.exercises.tools.EntityRetriever;

@Service
public class TrainLogService extends CrudDtoTransformService<
  TrainLogRepository,
  TrainLogCreateRequestDTO,
  TrainLogCreatePersistenceDTO,
  TrainLogUpdateRequestDTO,
  TrainLogUpdatePersistenceDTO,
  TrainLogReturnDTO,
  TrainLogEntity
> {
  
  @Autowired
  EntityRetriever entity_retriever;
  @Autowired
  ExerciseLogService exercise_log_service;

  public TrainLogReturnDTO getReturnDTO(TrainLogEntity entity) {
    return new TrainLogReturnDTO(entity);
  }

  public TrainLogEntity getEntity(TrainLogCreatePersistenceDTO dto) {
    return new TrainLogEntity(dto);
  }

  public TrainLogCreatePersistenceDTO getPersistenceCreateDTO(TrainLogCreateRequestDTO request_dto) {
    TrainEntity train = entity_retriever.getTrainByUuid(request_dto.getTrain_uuid());
    return new TrainLogCreatePersistenceDTO(request_dto, train);
  }

  public TrainLogUpdatePersistenceDTO getPersistenceUpdateDTO(TrainLogUpdateRequestDTO request_dto) {
    TrainEntity train = request_dto.getTrain_uuid() != null? entity_retriever.getTrainByUuid(request_dto.getTrain_uuid()) : null;
    return new TrainLogUpdatePersistenceDTO(request_dto, train);
  }

  @Override
  public TrainLogReturnDTO create(TrainLogCreateRequestDTO request_dto) {
    TrainLogReturnDTO dto = super.create(request_dto);

    TrainLogEntity train = entity_retriever.getTrainLogByUuid(dto.getUuid());
    List<ExerciseLogReturnDTO> exercises_logs = request_dto.getExercise_sets().stream().map(exercise -> exercise_log_service.create(exercise, train)).toList();
    dto.setExercise_sets(exercises_logs);

    return dto;
  }
}
