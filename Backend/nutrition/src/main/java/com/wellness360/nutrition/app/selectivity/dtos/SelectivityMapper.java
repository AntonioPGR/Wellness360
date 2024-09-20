package com.wellness360.nutrition.app.selectivity.dtos;

import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.selectivity.SelectivityBaseEntity;

public interface SelectivityMapper {
  
  SelectivityMapper INSTANCE = Mappers.getMapper(SelectivityMapper.class);

  SelectivityReturnDTO entityToReturn(SelectivityBaseEntity entity);

  SelectivityCreatePersistenceDTO createRequestToPersistence(long uuid, RecipeEntity recipe, FoodEntity food, CategoryEntity category);

  SelectivityBaseEntity createPersistenceToEntity(SelectivityCreatePersistenceDTO dto);

}
