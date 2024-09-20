package com.wellness360.nutrition.app.recipe.media.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;

public record MediaUpdatePersistenceDTO(
  String uuid,
  String media_url,
  RecipeEntity recipe
) implements CrudUpdatePersistenceDTO {
}