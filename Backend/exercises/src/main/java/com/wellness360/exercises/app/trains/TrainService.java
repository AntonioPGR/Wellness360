package com.wellness360.exercises.app.trains;

import com.wellness360.exercises.app.trains.dtos.TrainCreatePersistenceDTO;
import com.wellness360.exercises.app.trains.dtos.TrainCreateRequestDTO;
import com.wellness360.exercises.app.trains.dtos.TrainReturnDTO;
import com.wellness360.exercises.app.trains.dtos.TrainUpdatePersistenceDTO;
import com.wellness360.exercises.app.trains.dtos.TrainUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.service.CrudDtoTransformService;

public class TrainService extends CrudDtoTransformService<
  TrainRepository,
  TrainCreateRequestDTO,
  TrainCreatePersistenceDTO,
  TrainUpdateRequestDTO,
  TrainUpdatePersistenceDTO,
  TrainReturnDTO,
  TrainEntity
> {

  @Override
  public TrainReturnDTO getReturnDTO(TrainEntity entity) {
    return new TrainReturnDTO(entity);
  }

  @Override
  public TrainEntity getEntity(TrainCreatePersistenceDTO dto) {
    return new TrainEntity(dto);
  }

  @Override
  public TrainCreatePersistenceDTO getPersistenceCreateDTO(TrainCreateRequestDTO request_dto) {
    return new TrainCreatePersistenceDTO(request_dto);
  }

  @Override
  public TrainUpdatePersistenceDTO getPersistenceUpdateDTO(TrainUpdateRequestDTO request_dto) {
    return new TrainUpdatePersistenceDTO(request_dto);
  }
  
}
