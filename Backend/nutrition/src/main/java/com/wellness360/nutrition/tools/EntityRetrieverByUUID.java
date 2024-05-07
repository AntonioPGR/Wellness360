package com.wellness360.nutrition.tools;

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

  public CategoryEntity getCategoryByUuid(String uuid){
    Optional<CategoryEntity> category_optional = category_repository.findByUuid(uuid);
    return category_optional.isPresent()? category_optional.get() : null;
  }

  public TagEntity getTagByUuid(String uuid){
    Optional<TagEntity> tag_optional = tag_repository.findByUuid(uuid);
    return tag_optional.isPresent()? tag_optional.get() : null;
  }

  public RecipeEntity getRecipeByUuid(@NonNull String uuid) {
    Optional<RecipeEntity> recipe_optional = recipe_repository.findByUuid(uuid);
    return recipe_optional.isPresent()? recipe_optional.get() : null;
  }

  public FoodEntity getFoodByUuid(String uuid) {
    Optional<FoodEntity> food_optional = food_repository.findByUuid(uuid);
    return food_optional.isPresent()? food_optional.get() : null;
  }

}
