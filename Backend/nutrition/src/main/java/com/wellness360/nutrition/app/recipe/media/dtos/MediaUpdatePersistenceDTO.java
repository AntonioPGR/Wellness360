package com.wellness360.nutrition.app.recipe.media.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.dtos.UuidDTO;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class MediaUpdatePersistenceDTO implements UuidDTO {
  @NonNull
  String uuid;
  @NonNull
  String media_url;
  @Nonnull
  RecipeEntity recipe;

  public MediaUpdatePersistenceDTO(MediaUpdateRequestDTO dto, String media_url, RecipeEntity recipe){
    this.uuid = dto.getUuid();
    this.media_url = media_url;
    this.recipe = recipe;
  }

}