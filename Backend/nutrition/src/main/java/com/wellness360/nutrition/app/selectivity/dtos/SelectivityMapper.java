package com.wellness360.nutrition.app.selectivity.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.dtos.CategoryMapper;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.food.dtos.FoodMapper;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeMapper;
import com.wellness360.nutrition.app.selectivity.SelectivityBaseEntity;
import com.wellness360.nutrition.app.selectivity.preference.PreferenceEntity;
import com.wellness360.nutrition.app.selectivity.restriction.RestrictionEntity;

@Mapper(uses={RecipeMapper.class, CategoryMapper.class, FoodMapper.class})
public interface SelectivityMapper {
  
  SelectivityMapper INSTANCE = Mappers.getMapper(SelectivityMapper.class);

  SelectivityReturnDTO entityToReturn(SelectivityBaseEntity entity);

  @Mapping(target = "category", source = "category")
  @Mapping(target = "food", source = "food")
  SelectivityCreatePersistenceDTO createRequestToPersistence(String user_uuid, RecipeEntity recipe, FoodEntity food, CategoryEntity category);

  @Mapping(target = "category", source = "dto.category")
  @Mapping(target = "food", source = "dto.food")
  @Mapping(target = "recipe", source = "dto.recipe")
  @Mapping(target = "userUuid", source = "dto.user_uuid")
  PreferenceEntity createPersistenceToPreference(SelectivityCreatePersistenceDTO dto);

  @Mapping(target="userUuid", source="dto.user_uuid")
  RestrictionEntity createPersistenceToRestriction(SelectivityCreatePersistenceDTO dto);

}
