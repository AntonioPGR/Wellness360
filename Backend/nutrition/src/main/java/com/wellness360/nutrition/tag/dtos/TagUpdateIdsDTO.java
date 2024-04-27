package com.wellness360.nutrition.tag.dtos;

import com.wellness360.common.interfaces.CrudUpdateDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class TagUpdateIdsDTO implements CrudUpdateDTO{
  @Nonnull
  String uuid;
  @Nullable
  String name; 
  @Nullable
  String description;
  @Nullable
  String image_url;
  @Nullable
  String category_uuid;
}