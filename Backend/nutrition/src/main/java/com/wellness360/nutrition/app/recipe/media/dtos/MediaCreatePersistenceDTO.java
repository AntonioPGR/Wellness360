package com.wellness360.nutrition.app.recipe.media.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class MediaCreatePersistenceDTO {
  @NonNull
  String media_url;
  @Nonnull
  RecipeEntity recipe;

  public MediaCreatePersistenceDTO(String media_url, RecipeEntity recipe) {
    this.media_url = media_url;
    this.recipe = recipe;
  }

}
