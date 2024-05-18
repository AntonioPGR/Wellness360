package com.wellness360.nutrition.app.tag.dtos;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagCreateRequestDTO{
  @Nonnull
  String name; 
  @Nullable
  String description;
  @Nonnull
  MultipartFile image;
  @Nonnull
  String category_uuid;
}

