package com.wellness360.nutrition.app.recipe.dtos;

import java.util.List;

import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.media.dtos.MediaUpdateRequestDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdateRequestDTO;
import com.wellness360.nutrition.common.dtos.UpdateRequestDTO;
import com.wellness360.nutrition.common.services.ValidateService;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RecipeUpdateRequestDTO implements UpdateRequestDTO {
  @NonNull
  String uuid;
  @Nullable
  String name;
  @Nullable
  String description;
  @Nullable
  String user_uuid;
  @Nullable
  String tag_uuid;
  @Nullable
  String category_uuid;
  @Nullable
  List<IngredientUpdateRequestDTO> ingredients;
  @Nullable
  List<MediaUpdateRequestDTO> media;
  @Nullable
  List<SectionUpdateRequestDTO> sections;

  public void validate(ValidateService validator) {
    validator.validateName(name, true);
    validator.validateText(description);
    validator.validateUuid(user_uuid, true);
    validator.validateUuid(tag_uuid, true);
    validator.validateUuid(category_uuid, true);
    if(media != null) media.forEach(image -> validator.validateImage(image.getMedia()));
    if(ingredients != null) ingredients.forEach(ingredient -> ingredient.validate(validator));
    if(sections != null) sections.forEach(sections -> sections.validate(validator));
  }

}
