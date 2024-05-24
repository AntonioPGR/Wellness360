package com.wellness360.nutrition.app.logs;

import org.springframework.beans.factory.annotation.Autowired;
import com.wellness360.nutrition.app.logs.dtos.LogCreatePersistenceDTO;
import com.wellness360.nutrition.app.logs.dtos.LogCreateRequestDTO;
import com.wellness360.nutrition.app.logs.dtos.LogReturnDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdatePersistenceDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.services.CrudService;
import com.wellness360.nutrition.common.tools.EntityRetrieverByUUID;

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
    RecipeEntity recipe = getRecipe(ids_dto.getRecipe_uuid());
    return new LogCreatePersistenceDTO(ids_dto, recipe);
  }

  public LogUpdatePersistenceDTO getPersistenceUpdateDTO(LogUpdateRequestDTO ids_dto){
    RecipeEntity recipe = getRecipe(ids_dto.getRecipe_uuid());
    return new LogUpdatePersistenceDTO(ids_dto, recipe);
  }

  private RecipeEntity getRecipe(String uuid){
    return uuid_getter.getRecipeByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Unable to find Recipe with the passed uuid"));
  }

}
