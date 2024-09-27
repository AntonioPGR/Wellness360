package com.wellness360.nutrition.app.recipe.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientMapper;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaMappers;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionMapper;

@Mapper(uses = {MediaMappers.class, IngredientMapper.class, SectionMapper.class})
public interface RecipeMapper {

  RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);
  
  @Mapping(source = "dto.name", target = "name")
  @Mapping(source = "dto.description", target = "description")
  RecipeCreatePersistenceDTO createRequestToPersistence(RecipeCreateRequestDTO dto, String user_uuid, CategoryEntity category);

  RecipeReturnDTO entityToReturn(RecipeEntity entity);

  @Mapping(target = "description", source = "dto.description")
  @Mapping(target = "uuid", source = "dto.uuid")
  @Mapping(target = "name", source = "dto.name")
  RecipeUpdatePersistenceDTO updateRequestToPersistence(RecipeUpdateRequestDTO dto, String user_uuid, CategoryEntity category);
  
  @Mapping(ignore = true, target = "included_in_recipes")
  @Mapping(ignore = true, target = "ingredients")
  @Mapping(ignore = true, target = "logs")
  @Mapping(ignore = true, target = "media")
  @Mapping(ignore = true, target = "preferences")
  @Mapping(ignore = true, target = "restricions")
  @Mapping(ignore = true, target = "sections")
  RecipeEntity createPersistenceToEntity(RecipeCreatePersistenceDTO dto);

}
