package com.wellness360.nutrition.app.category.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryUpdateRequestDTO implements UuidDTO {
  @Nonnull
  protected String uuid;
  @Nullable
  protected String name;
  @Nullable
  protected String description;
  @Nullable
  protected MultipartFile image;
}
