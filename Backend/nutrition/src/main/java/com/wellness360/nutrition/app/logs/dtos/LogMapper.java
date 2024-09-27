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

  @Mapping(target = "user_uuid", source = "dto.user_uuid")
  LogCreatePersistenceDTO createRequestToPersistence(LogCreateRequestDTO dto, RecipeEntity recipe);

  LogReturnDTO entityToReturn(LogEntity entity);
  
  @Mapping(target = "uuid", source = "dto.uuid")
  @Mapping(target = "user_uuid", source = "dto.user_uuid")
  LogUpdatePersistenceDTO updateRequestToPersistence(LogUpdateRequestDTO dto, RecipeEntity recipe);

  LogEntity createPersistenceToEntity(LogCreatePersistenceDTO dto);
  
}
