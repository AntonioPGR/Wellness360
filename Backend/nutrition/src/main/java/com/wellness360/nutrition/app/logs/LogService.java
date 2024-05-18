package com.wellness360.nutrition.app.logs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.wellness360.nutrition.app.logs.dtos.LogCreatePersistenceDTO;
import com.wellness360.nutrition.app.logs.dtos.LogCreateRequestDTO;
import com.wellness360.nutrition.app.logs.dtos.LogReturnDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdatePersistenceDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.crud_bases.CrudService;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

import jakarta.persistence.EntityNotFoundException;

public class LogService extends CrudService<
  LogRepository,
  LogCreateRequestDTO,
  LogCreatePersistenceDTO,
  LogUpdateRequestDTO,
  LogUpdatePersistenceDTO,
  LogReturnDTO,
  LogEntity
> {

  @Autowired
  EntityRetrieverByUUID uuid_getter;

  @Override
  public LogReturnDTO getReturnDTO(LogEntity entity) {
    return new LogReturnDTO(entity);
  }

  @Override
  public LogEntity getEntity(LogCreatePersistenceDTO dto) {
    return new LogEntity(dto);
  }

  public LogCreatePersistenceDTO getPersistenceCreateDTO(LogCreateRequestDTO ids_dto){
    Optional<RecipeEntity> recipe_opt = uuid_getter.getRecipeByUuid(ids_dto.getRecipe_uuid());
    if(recipe_opt.isEmpty()) throw new EntityNotFoundException("Unable to find Recipe with the passed uuid");
    return new LogCreatePersistenceDTO(ids_dto, recipe_opt.get());
  }

  public LogUpdatePersistenceDTO getPersistenceUpdateDTO(LogUpdateRequestDTO ids_dto){
    Optional<RecipeEntity> recipe_opt = uuid_getter.getRecipeByUuid(ids_dto.getRecipe_uuid());
    if(recipe_opt.isEmpty()) throw new EntityNotFoundException("Unable to find Recipe with the passed uuid");
    return new LogUpdatePersistenceDTO(ids_dto, recipe_opt.get());
  }

}
