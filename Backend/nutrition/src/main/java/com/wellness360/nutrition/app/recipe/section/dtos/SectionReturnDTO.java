package com.wellness360.nutrition.app.recipe.section.dtos;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeReturnDTO;
import com.wellness360.nutrition.app.recipe.section.SectionEntity;

import io.micrometer.common.lang.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class SectionReturnDTO {
  @NonNull
  String uuid;
  @NonNull
  String name;
  @Nullable
  String text;
  @Nullable
  RecipeReturnDTO included_recipe_uuid;

  public SectionReturnDTO(SectionEntity entity){
    this.uuid = entity.getUuid();
    this.name = entity.getName();
    this.text = entity.getText();
    RecipeEntity included_recipe = entity.getIncluded_recipe();
    if(included_recipe != null) this.included_recipe_uuid = new RecipeReturnDTO(entity.getIncluded_recipe());
    else this.included_recipe_uuid = null;
  }

}
