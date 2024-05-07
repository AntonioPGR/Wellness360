package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class SectionCreateEntitiesDTO {
  @NonNull
  String name;
  @Nullable
  String text;
  @Nullable
  RecipeEntity included_recipe;
  @Nonnull
  RecipeEntity recipe;

  public SectionCreateEntitiesDTO(SectionCreateIdsDTO dto, RecipeEntity entity) {
    this.name = dto.getName();
    this.text = dto.getText();
    this.recipe = entity;
  }

}
