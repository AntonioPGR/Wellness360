package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;

public record LogCreatePersistenceDTO(
  LocalDate date,
  Short amount,
  RecipeEntity recipe,
  String user_uuid
) implements CrudCreatePersistenceDTO {
}
