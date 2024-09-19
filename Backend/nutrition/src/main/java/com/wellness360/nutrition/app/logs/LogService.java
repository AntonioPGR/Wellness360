package com.wellness360.nutrition.app.logs;

import org.springframework.beans.factory.annotation.Autowired;
import com.wellness360.nutrition.app.logs.dtos.LogCreatePersistenceDTO;
import com.wellness360.nutrition.app.logs.dtos.LogCreateRequestDTO;
import com.wellness360.nutrition.app.logs.dtos.LogMapper;
import com.wellness360.nutrition.app.logs.dtos.LogReturnDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdatePersistenceDTO;
import com.wellness360.nutrition.app.logs.dtos.LogUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.RecipeService;
import com.wellness360.nutrition.packages.crud.service.CrudDtoTransformService;

public class LogService extends CrudDtoTransformService<
  LogRepository,
  LogCreateRequestDTO,
  LogCreatePersistenceDTO,
  LogUpdateRequestDTO,
  LogUpdatePersistenceDTO,
  LogReturnDTO,
  LogEntity
> {

  @Autowired
  RecipeService recipe_service;

  public LogReturnDTO buildReturnDTO(LogEntity entity) {
    return LogMapper.INSTANCE.entityToReturn(entity);
  }

  public LogEntity getEntityByPersistenceDTO(LogCreatePersistenceDTO dto) {
    return LogMapper.INSTANCE.createPersistenceToEntity(dto);
  }

  public LogCreatePersistenceDTO getPersistenceCreateDTO(LogCreateRequestDTO dto){
    RecipeEntity recipe = recipe_service.getEntityByUuid(dto.recipe_uuid());
    return LogMapper.INSTANCE.createRequestToPersistence(dto, recipe);
  }

  public LogUpdatePersistenceDTO getPersistenceUpdateDTO(LogUpdateRequestDTO dto){
    RecipeEntity recipe = dto.recipe_uuid() != null? recipe_service.getEntityByUuid(dto.recipe_uuid()) : null;
    return LogMapper.INSTANCE.updateRequestToPersistence(dto, recipe);
  }

}
