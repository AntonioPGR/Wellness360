package com.wellness360.nutrition.app.recipe.media.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.media.MediaEntity;

@Mapper
public interface MediaMappers {
  
  MediaMappers INSTANCE = Mappers.getMapper(MediaMappers.class);

  MediaCreatePersistenceDTO createRequestToPersistence(String media_url, RecipeEntity recipe);

  MediaReturnDTO entityToReturn(MediaEntity entity);

  @Mapping(target = "uuid", source = "dto.uuid")
  MediaUpdatePersistenceDTO updateRequestToPersistence(MediaUpdateRequestDTO dto, String media_url, RecipeEntity recipe);

  MediaEntity createPersistenceToEntity(MediaCreatePersistenceDTO dto);

}
