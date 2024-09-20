package com.wellness360.nutrition.app.recipe.media.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;

public record MediaCreatePersistenceDTO(
  String media_url,
  RecipeEntity recipe
) {
}
