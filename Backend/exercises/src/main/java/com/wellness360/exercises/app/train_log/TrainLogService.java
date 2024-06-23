package com.wellness360.exercises.app.train_log;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.exercises.app.train_log.dtos.TrainLogCreatePersistenceDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogCreateRequestDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogReturnDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogUpdatePersistenceDTO;
import com.wellness360.exercises.app.train_log.dtos.TrainLogUpdateRequestDTO;
import com.wellness360.exercises.app.trains.TrainEntity;
import com.wellness360.exercises.packages.crud.service.CrudDtoTransformService;
import com.wellness360.exercises.tools.EntityRetriever;

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

}
