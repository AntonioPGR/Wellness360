package com.wellness360.nutrition.app.food.dtos;

import com.wellness360.nutrition.app.category.dtos.CategoryReturnDTO;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.tag.dtos.TagReturnSimplifiedDTO;
import com.wellness360.nutrition.common.dtos.UuidDTO;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class FoodReturnDTO implements UuidDTO{
  @Nonnull
  String uuid;
  @Nonnull
  String name;
  @Nullable
  String description;
  @Nonnull
  Float carbs;
  @Nonnull
  Float proteins;
  @Nonnull
  Float fats;
  @Nonnull
  Float saturated_fats;
  @Nonnull
  Float sodium;
  @Nonnull
  Float dietary_fiber;
  @Nonnull
  Short serving_amount;
  @Nonnull
  String image_url;
  @Nonnull
  CategoryReturnDTO category;
  @Nonnull
  TagReturnSimplifiedDTO tag;

  public FoodReturnDTO(FoodEntity entity) {
    this.uuid = entity.getUuid();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.carbs = entity.getCarbs();
    this.proteins = entity.getProteins();
    this.fats = entity.getFats();
    this.saturated_fats = entity.getSaturated_fats();
    this.sodium = entity.getSodium();
    this.dietary_fiber = entity.getDietary_fiber();
    this.serving_amount = entity.getServing_amount();
    this.image_url = entity.getImage_url();
    this.category = new CategoryReturnDTO(entity.getCategory());
    this.tag = new TagReturnSimplifiedDTO(entity.getTag());
  }

}
