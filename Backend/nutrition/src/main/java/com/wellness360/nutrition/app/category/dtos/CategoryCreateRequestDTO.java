package com.wellness360.nutrition.app.category.dtos;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateRequestDTO {
  @Nonnull
  protected String name;
  @Nullable
  protected String description;
  @Nonnull
  protected MultipartFile image;
}
