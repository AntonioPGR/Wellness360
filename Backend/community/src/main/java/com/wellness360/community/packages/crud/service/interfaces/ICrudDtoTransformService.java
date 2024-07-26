package com.wellness360.community.packages.crud.service.interfaces;

import java.util.Optional;

import com.wellness360.community.packages.crud.dtos.CrudCreatePersistenceDTO;
import com.wellness360.community.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.community.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.community.packages.crud.dtos.CrudUpdatePersistenceDTO;
import com.wellness360.community.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.community.packages.crud.entities.interfaces.ICrudEntity;

public interface ICrudDtoTransformService<
  RequestCreateDTO extends CrudCreateRequestDTO,
  PersistenceCreateDTO extends CrudCreatePersistenceDTO, 
  RequestUpdateDTO extends CrudUpdateRequestDTO,
  PersistenceUpdateDTO extends CrudUpdatePersistenceDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends ICrudEntity<PersistenceUpdateDTO>
> extends ICrudServiceBase<
  RequestCreateDTO,
  RequestUpdateDTO,
  ReturnDTO
>{

  public abstract Entity saveEntity(Entity new_entity);
  public abstract Optional<Entity> getEntityByUuid(String uuid);

  public abstract ReturnDTO getReturnDTO(Entity entity);
  public abstract Entity getEntity(PersistenceCreateDTO dto);
  public abstract PersistenceCreateDTO getPersistenceCreateDTO(RequestCreateDTO request_dto);
  public abstract PersistenceUpdateDTO getPersistenceUpdateDTO(RequestUpdateDTO request_dto);

}
