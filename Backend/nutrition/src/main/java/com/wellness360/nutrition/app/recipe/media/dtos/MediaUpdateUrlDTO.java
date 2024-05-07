package com.wellness360.nutrition.app.recipe.media.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.interfaces.UuidDTO;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class MediaUpdateUrlDTO implements UuidDTO {
  @NonNull
  String uuid;
  @NonNull
  String media_url;
  @Nonnull
  RecipeEntity recipe;

  public MediaUpdateUrlDTO(MediaUpdateFileDTO dto, RecipeEntity recipe){
    this.uuid = dto.getUuid();
    this.media_url = dto.getMedia();
    this.recipe = recipe;
  }

}