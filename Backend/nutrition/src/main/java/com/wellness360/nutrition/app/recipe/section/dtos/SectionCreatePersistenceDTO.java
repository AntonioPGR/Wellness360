package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.packages.crud.dtos.CrudCreatePersistenceDTO;

public record SectionCreatePersistenceDTO(
  String text,
  RecipeEntity included_recipe,
  RecipeEntity recipe
) implements CrudCreatePersistenceDTO{
}
