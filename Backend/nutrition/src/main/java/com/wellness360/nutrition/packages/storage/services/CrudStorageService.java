package com.wellness360.nutrition.packages.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.repositories.CrudRepository;
import com.wellness360.nutrition.packages.storage.StorageService;
import com.wellness360.nutrition.packages.storage.dtos.CrudStorageCreateRequestDTO;
import com.wellness360.nutrition.packages.storage.dtos.CrudStorageUpdateRequestDTO;
import com.wellness360.nutrition.packages.storage.services.interfaces.ICrudStorageService;
import com.wellness360.nutrition.packages.storage.services.interfaces.StorageEntity;
import com.wellness360.nutrition.packages.storage.tools.FileUtils;
import com.wellness360.nutrition.validation.Validator;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public abstract class CrudStorageService<
  Repository extends CrudRepository<Entity>, 
  RequestCreateDTO extends CrudStorageCreateRequestDTO,
  PersistenceCreateDTO extends CrudCreatePersistenceDTO, 
  RequestUpdateDTO extends CrudStorageUpdateRequestDTO,
  PersistenceUpdateDTO extends CrudUpdatePersistenceDTO,
  ReturnDTO extends CrudReturnDTO,
  Entity extends StorageEntity<PersistenceUpdateDTO>
> implements ICrudStorageService <
  RequestCreateDTO,
  PersistenceCreateDTO,
  RequestUpdateDTO,
  PersistenceUpdateDTO,
  ReturnDTO,
  Entity
> {

  @Autowired
  StorageService store_service;
  @Autowired
  protected Repository repository;
  @Autowired
  Validator validator_service;

  public ReturnDTO getByUuid(String uuid) {
    Entity entity = getEntityByUuid(uuid);
    ReturnDTO return_dto = getReturnDTO(entity);
    return return_dto;
  }

  public Page<ReturnDTO> getAll(Pageable pageable) {
    Page<Entity> item = repository.findAll(pageable);
    Page<ReturnDTO> return_dto = item.map(this::getReturnDTO);
    return return_dto;
  }

  public ReturnDTO create(RequestCreateDTO request_dto){
    request_dto.validate(validator_service);
    String file_name = store_service.store(request_dto.file(), getFolderName(), request_dto.name());
    PersistenceCreateDTO create_dto = getPersistenceCreateDTO(request_dto, file_name);
    Entity entity = getEntity(create_dto);
    entity = saveEntity(entity);
    return getReturnDTO(entity);
  }

  public ReturnDTO update(RequestUpdateDTO request_dto) {
    request_dto.validate(validator_service);
    Entity entity = getEntityByUuid(request_dto.uuid());
    String file_name = null;
    if(request_dto.file() != null) file_name = store_service.update(request_dto.file(), entity.getImage_url(), request_dto.name());
    else if(request_dto.name() != null && !entity.getImage_url().contains(FileUtils.cleanPath(request_dto.name()))) file_name = store_service.update(entity.getImage_url(), request_dto.name());
    PersistenceUpdateDTO persistence_dto = getPersistenceUpdateDTO(request_dto, file_name);
    entity.update(persistence_dto);
    saveEntity(entity);
    return getReturnDTO(entity);
  }
  
  public void delete(String uuid) {
    Entity entity = getEntityByUuid(uuid);
    store_service.delete(entity.getImage_url());
    repository.deleteByUuid(uuid);
  }

  public Entity saveEntity(Entity new_entity){
    return repository.saveAndFlush(new_entity);
  }

  public Entity getEntityByUuid(String uuid){
    return repository.findByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Unable to find object with passed uuid"));
  }

}
