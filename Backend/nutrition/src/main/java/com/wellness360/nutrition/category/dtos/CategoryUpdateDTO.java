package com.wellness360.nutrition.category.dtos;

import com.wellness360.common.crud_default.interfaces.CrudUpdateDTO;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateDTO implements CrudUpdateDTO {
  @Nonnull
  private String uuid;
  @Nullable
  private String name;
  @Nullable
  private String description;
  @Nullable
  private String image_url;
}
