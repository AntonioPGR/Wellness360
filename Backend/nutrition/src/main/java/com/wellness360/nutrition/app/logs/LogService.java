package com.wellness360.nutrition.app.logs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellness360.nutrition.app.logs.dtos.LogCreateEntitiesDTO;
import com.wellness360.nutrition.app.logs.dtos.LogCreateIdsDTO;
import com.wellness360.nutrition.app.logs.dtos.LogReturnDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdateEntitiesDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdateIdsDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.CrudBases.CrudService;
import com.wellness360.nutrition.tools.EntityRetrieverByUUID;

public class LogService extends CrudService<
  LogRepository,
  LogCreateEntitiesDTO,
  LogUpdateEntitiesDTO,
  LogReturnDTO,
  LogEntity
> {

  @Autowired
  EntityRetrieverByUUID uuid_getter;

  public LogReturnDTO create(LogCreateIdsDTO ids_dto){
    RecipeEntity recipe = uuid_getter.getRecipeByUuid(ids_dto.getRecipe_uuid());
    LogCreateEntitiesDTO entities_dto = new LogCreateEntitiesDTO(ids_dto, recipe);
    return super.create(entities_dto);
  }

  public Optional<LogReturnDTO> update(LogUpdateIdsDTO ids_dto){
    RecipeEntity recipe = uuid_getter.getRecipeByUuid(ids_dto.getRecipe_uuid());
    LogUpdateEntitiesDTO entities_dto = new LogUpdateEntitiesDTO(ids_dto, recipe);
    return super.update(entities_dto);
  }


  @Override
  public LogReturnDTO entityToReturnDTO(LogEntity entity) {
    return new LogReturnDTO(entity);
  }

  @Override
  public LogEntity createDTOtoEntity(LogCreateEntitiesDTO dto) {
    return new LogEntity(dto);
  }
  
}
