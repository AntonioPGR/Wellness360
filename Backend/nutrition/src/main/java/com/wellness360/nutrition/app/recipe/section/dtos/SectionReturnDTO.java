package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record SectionReturnDTO(
  String uuid,
  String text,
  String included_recipe_uuid
) implements CrudReturnDTO {
}
