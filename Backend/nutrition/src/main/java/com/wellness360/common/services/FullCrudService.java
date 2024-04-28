package com.wellness360.common.services;

import java.net.URI;
import java.util.Optional;
import javax.swing.text.html.parser.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.common.Entities.BaseIdsEntity;
import com.wellness360.common.interfaces.CrudUpdateDTO;
import com.wellness360.common.repositories.IdRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Transactional
@SuppressWarnings("hiding")
public abstract class FullCrudService<
  Repository extends IdRepository<Entity>, 
  CreateDTO, 
  UpdateDTO extends CrudUpdateDTO,
  ReturnDTO,
  Entity extends BaseIdsEntity<UpdateDTO>
> {

  @Autowired
  protected Repository repository;

  // Abstract Methods
  protected abstract ReturnDTO createReturnDTO(Entity entity);
  protected abstract Entity createEntity(CreateDTO dto);
  protected abstract String getReturnURL(String uuid);


  // Default Methods
  public Optional<ReturnDTO> getByUuid(@Valid String uuid) {
    Optional<Entity> optional = repository.findByUuid(uuid);
    if(optional.isPresent()){
      ReturnDTO return_dto = this.createReturnDTO(optional.get());
      return Optional.of(return_dto);
    }
    return Optional.empty();
  }

  public Page<ReturnDTO> getAll(Pageable pageable) {
    Page<Entity> item = repository.findAll(pageable);
    Page<ReturnDTO> return_dto = item.map((entity) -> createReturnDTO(entity));
    return return_dto;
  }

  public Optional<URI> create(CreateDTO create_dto){
    Entity new_item = this.createEntity(create_dto);
    repository.save(new_item);
    try{
      String uuid = new_item.getUuid();
      URI return_uri = new URI(this.getReturnURL(uuid));
      return Optional.of(return_uri);
    } catch(Exception e) {
      return Optional.empty();
    }
  }

  public Optional<ReturnDTO> update(UpdateDTO update_dto) {
    String uuid = update_dto.getUuid();
    Optional<Entity> optional = repository.findByUuid(uuid);
    if(optional.isPresent()){
      Entity entity = optional.get();
      entity.update(update_dto);
      repository.save(entity);
      return Optional.of(createReturnDTO(entity));
    }
    return Optional.empty();
  }
  
  public void delete(String uuid) {
    repository.deleteByUuid(uuid);
  }

}
