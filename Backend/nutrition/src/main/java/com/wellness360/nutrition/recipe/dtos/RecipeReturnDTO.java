package com.wellness360.nutrition.recipe.dtos;

import com.wellness360.nutrition.recipe.RecipeEntity;

import jakarta.annotation.Nullable;
import lombok.NonNull;

public class RecipeReturnDTO {
  @NonNull
  String uuid;
  @NonNull
  String name; 
  @Nullable
  String description;
  @NonNull
  String image_url;

  public RecipeReturnDTO(RecipeEntity recipe) {
    
  }
  
}
