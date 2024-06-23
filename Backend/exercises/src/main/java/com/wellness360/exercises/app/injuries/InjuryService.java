package com.wellness360.exercises.app.injuries;

import com.wellness360.exercises.app.injuries.dtos.InjuryCreatePersistenceDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryCreateRequestDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryReturnDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryUpdatePersistenceDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryUpdateRequestDTO;
import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.service.CrudDtoTransformService;

public class InjuryService extends CrudDtoTransformService<
  InjuryRepository,
  InjuryCreateRequestDTO,
  InjuryCreatePersistenceDTO,
  InjuryUpdateRequestDTO,
  InjuryUpdatePersistenceDTO,
  InjuryReturnDTO,
  InjuryEntity
> {

  @Override
  public InjuryReturnDTO getReturnDTO(InjuryEntity entity) {
    return new InjuryReturnDTO(entity);
  }

  @Override
  public InjuryEntity getEntity(InjuryCreatePersistenceDTO dto) {
    return new InjuryEntity(dto);
  }

  @Override
  public InjuryCreatePersistenceDTO getPersistenceCreateDTO(InjuryCreateRequestDTO request_dto) {
    String body_muscle_name = request_dto.getBody_muscle().toUpperCase().trim();
    BodyMusclesEnum body_muscle = BodyMusclesEnum.valueOf(body_muscle_name);
    return new InjuryCreatePersistenceDTO(request_dto, body_muscle);
  }

  @Override
  public InjuryUpdatePersistenceDTO getPersistenceUpdateDTO(InjuryUpdateRequestDTO request_dto) {
    String body_muscle_name = request_dto.getBody_muscle().toUpperCase().trim();
    BodyMusclesEnum body_muscle = body_muscle_name != null? BodyMusclesEnum.valueOf(body_muscle_name) : null;
    return new InjuryUpdatePersistenceDTO(request_dto, body_muscle);
  }
  
}
