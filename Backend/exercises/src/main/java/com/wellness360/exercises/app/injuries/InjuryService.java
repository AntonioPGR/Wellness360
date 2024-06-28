package com.wellness360.exercises.app.injuries;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.injuries.dtos.InjuryCreatePersistenceDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryCreateRequestDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryReturnDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryUpdatePersistenceDTO;
import com.wellness360.exercises.app.injuries.dtos.InjuryUpdateRequestDTO;
import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.service.CrudDtoTransformService;

@Service
public class InjuryService extends CrudDtoTransformService<
  InjuryRepository,
  InjuryCreateRequestDTO,
  InjuryCreatePersistenceDTO,
  InjuryUpdateRequestDTO,
  InjuryUpdatePersistenceDTO,
  InjuryReturnDTO,
  InjuryEntity
> {

  public InjuryReturnDTO getReturnDTO(InjuryEntity entity) {
    return new InjuryReturnDTO(entity);
  }

  public InjuryEntity getEntity(InjuryCreatePersistenceDTO dto) {
    return new InjuryEntity(dto);
  }

  public InjuryCreatePersistenceDTO getPersistenceCreateDTO(InjuryCreateRequestDTO request_dto) {
    String body_muscle_name = request_dto.getBody_part().toUpperCase().strip();
    BodyMusclesEnum body_muscle = BodyMusclesEnum.valueOf(body_muscle_name);
    return new InjuryCreatePersistenceDTO(request_dto, body_muscle);
  }

  public InjuryUpdatePersistenceDTO getPersistenceUpdateDTO(InjuryUpdateRequestDTO request_dto) {
    BodyMusclesEnum body_muscle = request_dto.getBody_part() != null? BodyMusclesEnum.valueOf(request_dto.getBody_part().toUpperCase().trim()) : null;
    return new InjuryUpdatePersistenceDTO(request_dto, body_muscle);
  }

  // METHODS
  public List<InjuryReturnDTO> getByUserUuid(String uuid) {
    return repository.findAllByUserUuid(uuid).stream().map((entity) -> new InjuryReturnDTO(entity)).toList();
  }
  
}
