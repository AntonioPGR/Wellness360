package com.wellness360.nutrition.tag.dtos;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class TagCreateIdsDTO{
  @Nonnull
  String name; 
  @Nullable
  String description;
  @Nonnull
  String image_url;
  @Nonnull
  String category_uuid;
}

