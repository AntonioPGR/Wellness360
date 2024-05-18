package com.wellness360.nutrition.app.tag.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.crud_bases.interfaces.UuidDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagUpdateRequestDTO implements UuidDTO{
  @Nonnull
  String uuid;
  @Nullable
  String name; 
  @Nullable
  String description;
  @Nullable
  MultipartFile image;
  @Nullable
  String category_uuid;
}