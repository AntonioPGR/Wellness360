package com.wellness360.users.packages.storage.services.interfaces;

import java.util.Optional;

import com.wellness360.users.packages.crud.dtos.CrudCreatePersistenceDTO;
import com.wellness360.users.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.users.packages.crud.dtos.CrudUpdatePersistenceDTO;
import com.wellness360.users.packages.crud.entities.interfaces.ICrudEntity;
import com.wellness360.users.packages.crud.service.interfaces.ICrudServiceBase;
import com.wellness360.users.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.users.packages.storage.dtos.CrudStorageUpdateRequestDTO;

public interface ICrudStorageService<
  RequestCreateDTO extends CrudStorageCreateRequestDTO,
  PersistenceCreateDTO extends CrudCreatePersistenceDTO, 
  RequestUpdateDTO extends CrudStorageUpdateRequestDTO,
  PersistenceUpdateDTO extends CrudUpdatePersistenceDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends ICrudEntity<PersistenceUpdateDTO>
> extends ICrudServiceBase<
  RequestCreateDTO,
  RequestUpdateDTO,
  ReturnDTO
>{

  public abstract String getFolderName();

  public abstract Entity saveEntity(Entity new_entity);
  public abstract Optional<Entity> getEntityByUuid(String uuid);

  public abstract ReturnDTO getReturnDTO(Entity entity);
  public abstract Entity getEntity(PersistenceCreateDTO dto);
  public abstract PersistenceCreateDTO getPersistenceCreateDTO(RequestCreateDTO request_dto, String image_url);
  public abstract PersistenceUpdateDTO getPersistenceUpdateDTO(RequestUpdateDTO request_dto, String image_url);

}
