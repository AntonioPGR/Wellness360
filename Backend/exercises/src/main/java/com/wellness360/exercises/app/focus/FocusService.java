package com.wellness360.exercises.app.focus;

import org.springframework.stereotype.Service;

import com.wellness360.exercises.app.focus.dtos.FocusCreatePersistenceDTO;
import com.wellness360.exercises.app.focus.dtos.FocusCreateRequestDTO;
import com.wellness360.exercises.app.focus.dtos.FocusReturnDTO;
import com.wellness360.exercises.app.focus.dtos.FocusUpdatePersistenceDTO;
import com.wellness360.exercises.app.focus.dtos.FocusUpdateRequestDTO;
import com.wellness360.exercises.enums.BodyMusclesEnum;
import com.wellness360.exercises.packages.crud.service.CrudDtoTransformService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FocusService extends CrudDtoTransformService<
  FocusRepository,
  FocusCreateRequestDTO,
  FocusCreatePersistenceDTO,
  FocusUpdateRequestDTO,
  FocusUpdatePersistenceDTO,
  FocusReturnDTO,
  FocusEntity
> {

  public FocusReturnDTO getReturnDTO(FocusEntity entity) {
    return new FocusReturnDTO(entity);
  }

  public FocusEntity getEntity(FocusCreatePersistenceDTO dto) {
    return new FocusEntity(dto);
  }

  public FocusCreatePersistenceDTO getPersistenceCreateDTO(FocusCreateRequestDTO request_dto) {
    String body_muscle_name = request_dto.getBody_muscle().toUpperCase().trim();
    BodyMusclesEnum body_muscle = BodyMusclesEnum.valueOf(body_muscle_name);
    return new FocusCreatePersistenceDTO(request_dto, body_muscle);
  }

  public FocusUpdatePersistenceDTO getPersistenceUpdateDTO(FocusUpdateRequestDTO request_dto) {
    String body_muscle_name = request_dto.getBody_muscle().toUpperCase().trim();
    BodyMusclesEnum body_muscle = body_muscle_name != null? BodyMusclesEnum.valueOf(body_muscle_name) : null;
    return new FocusUpdatePersistenceDTO(request_dto, body_muscle);
  }

}
