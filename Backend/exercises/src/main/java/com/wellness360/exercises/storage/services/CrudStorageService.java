package com.wellness360.exercises.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.exercises.crud.dtos.UpdateRequestDTO;
import com.wellness360.exercises.crud.dtos.UuidDTO;
import com.wellness360.exercises.crud.dtos.ValidatableDTO;
import com.wellness360.exercises.crud.interfaces.INameEntity;
import com.wellness360.exercises.crud.repositories.UUIDRepository;
import com.wellness360.exercises.crud.service.CrudService;
import com.wellness360.exercises.tools.EntityRetriever;

import jakarta.persistence.EntityNotFoundException;

@Service
public abstract class CrudStorageService<
  Repository extends UUIDRepository<Entity>, 
  RequestCreateDTO extends ValidatableDTO,
  PersistenceCreateDTO, 
  RequestUpdateDTO extends UpdateRequestDTO,
  PersistenceUpdateDTO extends UuidDTO,
  ReturnDTO,
  Entity extends INameEntity<PersistenceUpdateDTO>
> extends CrudService <
  Repository,
  RequestCreateDTO,
  PersistenceCreateDTO,
  RequestUpdateDTO,
  PersistenceUpdateDTO,
  ReturnDTO,
  Entity
> {

  @Autowired
  StorageEntityFileService store_service;
  @Autowired
  EntityRetriever entity_retriever;

  public final String folder_name;

  public CrudStorageService(String folder){
    this.folder_name = folder;
  }
  
  public void delete(String uuid) {
    Entity entity = getEntityByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Unable to find object with uuid"));
    store_service.delete(
      entity.getName(),
      folder_name
    );
    super.delete(uuid);
  }

}
