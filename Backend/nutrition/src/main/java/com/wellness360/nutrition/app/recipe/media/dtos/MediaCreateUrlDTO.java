package com.wellness360.nutrition.app.recipe.media.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class MediaCreateUrlDTO {
  @NonNull
  String media_url;
  @Nonnull
  RecipeEntity recipe;

  public MediaCreateUrlDTO(MediaCreateFileDTO dto, RecipeEntity recipe) {
    this.media_url = dto.getMedia();
    this.recipe = recipe;
  }

}
