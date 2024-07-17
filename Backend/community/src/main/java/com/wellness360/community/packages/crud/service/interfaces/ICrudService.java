package com.wellness360.exercises.packages.crud.service.interfaces;

import java.util.Optional;

import com.wellness360.exercises.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;


public interface ICrudService<
  RequestCreateDTO extends CrudCreateRequestDTO,
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends IBaseEntity<RequestUpdateDTO>
> extends ICrudServiceBase<
  RequestCreateDTO,
  RequestUpdateDTO,
  ReturnDTO
> {
  public abstract Entity saveEntity(Entity new_entity);
  public abstract Optional<Entity> getEntityByUuid(String uuid);

  public abstract ReturnDTO getReturnDTO(Entity entity);
  public abstract Entity getEntity(RequestCreateDTO dto);
}
