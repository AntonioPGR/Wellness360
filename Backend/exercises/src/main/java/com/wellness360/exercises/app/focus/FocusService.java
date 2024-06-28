package com.wellness360.exercises.app.focus;

import java.util.List;

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
    String body_muscle_name = request_dto.getBody_part().toUpperCase().strip();
    BodyMusclesEnum body_muscle = BodyMusclesEnum.valueOf(body_muscle_name);
    Short priority = request_dto.getPriority().shortValue();
    return new FocusCreatePersistenceDTO(request_dto, body_muscle, priority);
  }

  public FocusUpdatePersistenceDTO getPersistenceUpdateDTO(FocusUpdateRequestDTO request_dto) {
    BodyMusclesEnum body_muscle = request_dto.getBody_part() != null? BodyMusclesEnum.valueOf(request_dto.getBody_part().toUpperCase().strip()) : null;
    Short priority = request_dto.getPriority() != null? request_dto.getPriority().shortValue() : null;
    return new FocusUpdatePersistenceDTO(request_dto, body_muscle, priority);
  }

  // METHODS
  public List<FocusReturnDTO> getByUserUuid(String uuid) {
    return repository.findAllByUserUuid(uuid).stream().map((entity) -> new FocusReturnDTO(entity)).toList();
  }

}
