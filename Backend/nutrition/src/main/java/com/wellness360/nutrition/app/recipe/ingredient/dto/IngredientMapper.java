package com.wellness360.nutrition.app.recipe.ingredient.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;

@Mapper
public interface IngredientMapper {
  
  IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

  IngredientCreatePersistenceDTO createRequestToPersistence(IngredientCreateRequestDTO dto, FoodEntity food, RecipeEntity recipe);

  @Mapping(source = "dto.uuid", target = "uuid")
  IngredientUpdatePersistenceDTO updateRequestToPersistence(IngredientUpdateRequestDTO dto, FoodEntity food, RecipeEntity recipe);

  IngredientReturnDTO entityToReturnDTO(IngredientEntity entity);

  IngredientEntity createPersistenceToEntity(IngredientCreatePersistenceDTO dto);

}
