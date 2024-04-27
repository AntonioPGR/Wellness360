package com.wellness360.nutrition.food.dtos;

import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.tag.TagEntity;
import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class FoodCreateEntitiesDTO{
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
  TagEntity tag;
  @Nonnull
  CategoryEntity category;

  public FoodCreateEntitiesDTO(FoodCreateIdsDTO dto, TagEntity tag, CategoryEntity category){
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.carbs = dto.getCarbs();
    this.proteins = dto.getProteins();
    this.fats = dto.getFats();
    this.saturated_fats = dto.getSaturated_fats();
    this.sodium = dto.getSodium();
    this.dietary_fiber = dto.getDietary_fiber();
    this.serving_amount = dto.getServing_amount();
    this.image_url = dto.getImage_url();
    this.tag = tag;
    this.category = category;
  }

}
