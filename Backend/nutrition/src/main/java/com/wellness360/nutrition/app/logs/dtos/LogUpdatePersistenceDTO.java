package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudUpdatePersistenceDTO;

public record LogUpdatePersistenceDTO(
  String uuid,
  LocalDate date,
  Short amount,
  RecipeEntity recipe,
  String user_uuid
) implements CrudUpdatePersistenceDTO {
}
