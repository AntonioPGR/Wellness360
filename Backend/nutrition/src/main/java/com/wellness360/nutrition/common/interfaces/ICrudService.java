package com.wellness360.nutrition.common.interfaces;

import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wellness360.nutrition.common.dtos.UuidDTO;

@SuppressWarnings("hiding")
public interface ICrudService<
  RequestCreateDTO,
  PersistenceCreateDTO, 
  RequestUpdateDTO extends UuidDTO,
  PersistenceUpdateDTO extends UuidDTO,
  ReturnDTO,
  Entity extends IBaseEntity<PersistenceUpdateDTO>
> {
  public ReturnDTO getByUuid(String uuid);
  public Page<ReturnDTO> getAll(Pageable pageable);
  public ReturnDTO create(RequestCreateDTO create_dto);
  public ReturnDTO update(RequestUpdateDTO update_dto);
  public void delete(String uuid);


  public abstract Entity saveEntity(Entity new_entity);
  public abstract Optional<Entity> getEntityByUuid(String uuid);


  public abstract ReturnDTO getReturnDTO(Entity entity);
  public abstract Entity getEntity(PersistenceCreateDTO dto);
  public abstract PersistenceCreateDTO getPersistenceCreateDTO(RequestCreateDTO request_dto);
  public abstract PersistenceUpdateDTO getPersistenceUpdateDTO(RequestUpdateDTO request_dto);
}
