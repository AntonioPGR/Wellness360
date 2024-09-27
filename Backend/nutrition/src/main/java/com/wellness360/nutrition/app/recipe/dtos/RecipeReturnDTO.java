package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientReturnDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaReturnDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionReturnDTO;
import com.wellness360.nutrition.packages.crud.dtos.CrudReturnDTO;

public record RecipeReturnDTO(
  String uuid,
  String name,
  String description,
  // String user_uuid,
  CategoryReturnDTO category,
  List<MediaReturnDTO> media,
  List<IngredientReturnDTO> ingredients,
  List<SectionReturnDTO> sections
) implements CrudReturnDTO {
}
