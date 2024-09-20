package com.wellness360.nutrition.packages.storage.services.interfaces;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;
import com.wellness360.nutrition.packages.crud.service.interfaces.ICrudBaseService;
import com.wellness360.nutrition.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.nutrition.packages.storage.dtos.CrudStorageUpdateRequestDTO;

public interface ICrudStorageService<
  RequestCreateDTO extends CrudStorageCreateRequestDTO,
  PersistenceCreateDTO extends CrudCreatePersistenceDTO, 
  RequestUpdateDTO extends CrudStorageUpdateRequestDTO,
  PersistenceUpdateDTO extends CrudUpdatePersistenceDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends CrudEntity<PersistenceUpdateDTO>
> extends ICrudBaseService<
  RequestCreateDTO,
  RequestUpdateDTO,
  ReturnDTO
>{

  public abstract String getFolderName();

  public abstract Entity saveEntity(Entity new_entity);
  public abstract Entity getEntityByUuid(String uuid);

  public abstract ReturnDTO getReturnDTO(Entity entity);
  public abstract Entity getEntity(PersistenceCreateDTO dto);
  public abstract PersistenceCreateDTO getPersistenceCreateDTO(RequestCreateDTO request_dto, String image_url);
  public abstract PersistenceUpdateDTO getPersistenceUpdateDTO(RequestUpdateDTO request_dto, String image_url);

}
