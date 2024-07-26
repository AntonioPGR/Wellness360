package com.wellness360.community.packages.crud.service.interfaces;

import java.util.Optional;

import com.wellness360.community.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.community.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.community.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.community.packages.crud.entities.interfaces.ICrudEntity;


public interface ICrudService<
  RequestCreateDTO extends CrudCreateRequestDTO,
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends ICrudEntity<RequestUpdateDTO>
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
