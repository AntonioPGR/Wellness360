package com.wellness360.nutrition.app.logs.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.logs.LogEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeMapper;

@Mapper(uses = RecipeMapper.class)
public interface LogMapper {

  LogMapper INSTANCE = Mappers.getMapper(LogMapper.class);

  LogCreatePersistenceDTO createRequestToPersistence(LogCreateRequestDTO dto, RecipeEntity recipe);

  LogReturnDTO entityToReturn(LogEntity entity);
  
  @Mapping(target = "uuid", source = "dto.uuid")
  LogUpdatePersistenceDTO updateRequestToPersistence(LogUpdateRequestDTO dto, RecipeEntity recipe);

  LogEntity createPersistenceToEntity(LogCreatePersistenceDTO dto);
  
}
