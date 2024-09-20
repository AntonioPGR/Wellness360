package com.wellness360.nutrition.app.logs.dtos;

import java.time.LocalDate;

import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record LogReturnDTO(
  String uuid,
  LocalDate date,
  Short amount,
  RecipeReturnDTO recipe
  // String user_uuid
) implements CrudReturnDTO {
}
