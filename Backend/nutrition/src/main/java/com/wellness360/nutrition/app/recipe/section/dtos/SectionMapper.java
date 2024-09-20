package com.wellness360.nutrition.app.recipe.section.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeMapper;
import com.wellness360.nutrition.app.recipe.section.SectionEntity;

@Mapper(uses = RecipeMapper.class)
public interface SectionMapper {
  
  SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);

  SectionCreatePersistenceDTO createRequestToPersistence(SectionCreateRequestDTO dto, RecipeEntity recipe, RecipeEntity included_recipe);

  @Mapping(target = "included_recipe_uuid", source = "entity.included_recipe")
  SectionReturnDTO entityToReturn(SectionEntity entity);

  @Mapping(target = "uuid", source = "dto.uuid")
  SectionUpdatePersistenceDTO updateRequestToPersistence( SectionUpdateRequestDTO dto, RecipeEntity recipe, RecipeEntity included_recipe);

  SectionEntity createPersistenceToEntity(SectionCreatePersistenceDTO dto);

}
