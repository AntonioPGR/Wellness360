package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.common.interfaces.UuidDTO;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class SectionUpdateEntitiesDTO implements UuidDTO {
  @NonNull
  String uuid;
  @Nullable
  String name;
  @Nullable
  String text;
  @Nullable
  RecipeEntity included_recipe;
  @Nonnull
  RecipeEntity recipe;

  public SectionUpdateEntitiesDTO(SectionUpdateIdsDTO dto, RecipeEntity recipe, RecipeEntity included_recipe) {
    this.uuid = dto.getUuid();
    this.name = dto.getName();
    this.text = dto.getText();
    this.recipe = recipe;
    this.included_recipe = included_recipe;
  }

}
