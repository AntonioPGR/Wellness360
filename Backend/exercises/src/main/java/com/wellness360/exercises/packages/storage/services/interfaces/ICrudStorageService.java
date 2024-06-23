package com.wellness360.exercises.packages.storage.services.interfaces;

import java.util.Optional;

import com.wellness360.exercises.packages.crud.dtos.CrudCreatePersistenceDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.exercises.packages.crud.dtos.CrudUpdatePersistenceDTO;
import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;
import com.wellness360.exercises.packages.crud.service.interfaces.ICrudServiceBase;
import com.wellness360.exercises.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.exercises.packages.storage.dtos.CrudStorageUpdateRequestDTO;

public interface ICrudStorageService<
  RequestCreateDTO extends CrudStorageCreateRequestDTO,
  PersistenceCreateDTO extends CrudCreatePersistenceDTO, 
  RequestUpdateDTO extends CrudStorageUpdateRequestDTO,
  PersistenceUpdateDTO extends CrudUpdatePersistenceDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends IBaseEntity<PersistenceUpdateDTO>
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
  public abstract PersistenceCreateDTO getPersistenceCreateDTO(RequestCreateDTO request_dto, String file_name);
  public abstract PersistenceUpdateDTO getPersistenceUpdateDTO(RequestUpdateDTO request_dto, String file_name);

}
