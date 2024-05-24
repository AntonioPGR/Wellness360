package com.wellness360.nutrition.common.tools;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.category.CategoryRepository;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.food.FoodRepository;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.RecipeRepository;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.app.tag.TagRepository;

import lombok.NonNull;

@Service
public class EntityRetrieverByUUID {

  @Autowired 
  CategoryRepository category_repository;
  @Autowired
  TagRepository tag_repository;
  @Autowired
  RecipeRepository recipe_repository;
  @Autowired
  FoodRepository food_repository;

  public Optional<CategoryEntity> getCategoryByUuid(String uuid){
    return category_repository.findByUuid(uuid);
  }

  public Optional<TagEntity> getTagByUuid(String uuid){
    return tag_repository.findByUuid(uuid);
  }

  public Optional<RecipeEntity> getRecipeByUuid(@NonNull String uuid) {
    return recipe_repository.findByUuid(uuid);
  }

  public Optional<FoodEntity> getFoodByUuid(String uuid) {
    return food_repository.findByUuid(uuid);
  }

}
