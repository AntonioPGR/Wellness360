package com.wellness360.nutrition.app.recipe.section.dtos;

import io.micrometer.common.lang.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class SectionUpdateRequestDTO {
  @NonNull
  String uuid;
  @Nullable
  String text;
  @Nullable
  String included_recipe_uuid;
}