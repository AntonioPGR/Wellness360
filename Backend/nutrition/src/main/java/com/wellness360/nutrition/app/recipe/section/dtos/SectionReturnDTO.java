package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record SectionReturnDTO(
  String uuid,
  String text,
  RecipeReturnDTO included_recipe_uuid
) implements CrudReturnDTO {
}
