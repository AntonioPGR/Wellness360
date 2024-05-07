package com.wellness360.nutrition.app.recipe.section.dtos;

import io.micrometer.common.lang.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class SectionCreateIdsDTO {
  @NonNull
  String name;
  @Nullable
  String text;
  @Nullable
  String included_recipe_uuid;
}
