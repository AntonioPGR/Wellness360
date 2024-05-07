package com.wellness360.nutrition.app.tag.dtos;

import com.wellness360.nutrition.common.interfaces.UuidDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class TagUpdateIdsDTO implements UuidDTO{
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