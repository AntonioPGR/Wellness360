package com.wellness360.nutrition.food.dtos;

import com.wellness360.common.interfaces.CrudUpdateDTO;
import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.tag.TagEntity;
import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class FoodUpdateEntitiesDTO implements CrudUpdateDTO{
  @Nonnull
  String uuid;
  @Nullable
  String name;
  @Nullable
  String description;
  @Nullable
  Float carbs;
  @Nullable
  Float proteins;
  @Nullable
  Float fats;
  @Nullable
  Float saturated_fats;
  @Nullable
  Float sodium;
  @Nullable
  Float dietary_fiber;
  @Nullable
  Short serving_amount;
  @Nullable
  String image_url;
  @Nullable
  TagEntity tag;
  @Nullable
  CategoryEntity category;

  public FoodUpdateEntitiesDTO(FoodUpdateIdsDTO dto, TagEntity tag, CategoryEntity category){
    this.uuid = dto.getUuid();
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
