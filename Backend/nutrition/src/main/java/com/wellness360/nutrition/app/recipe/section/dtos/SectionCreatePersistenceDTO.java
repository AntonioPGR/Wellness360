package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class SectionCreatePersistenceDTO {
  @Nullable
  String text;
  @Nullable
  RecipeEntity included_recipe;
  @Nonnull
  RecipeEntity recipe;

  public SectionCreatePersistenceDTO(SectionCreateRequestDTO dto, RecipeEntity entity, RecipeEntity included_recipe) {
    this.text = dto.getText();
    this.recipe = entity;
    this.included_recipe = included_recipe;
  }

}
