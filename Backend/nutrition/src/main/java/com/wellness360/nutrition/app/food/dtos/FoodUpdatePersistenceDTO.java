package com.wellness360.nutrition.app.food.dtos;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class FoodUpdatePersistenceDTO implements UuidDTO{
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

  public FoodUpdatePersistenceDTO(FoodUpdateRequestDTO dto, String image_url, TagEntity tag, CategoryEntity category){
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
    this.image_url = image_url;
    this.tag = tag;
    this.category = category;
  }

}
