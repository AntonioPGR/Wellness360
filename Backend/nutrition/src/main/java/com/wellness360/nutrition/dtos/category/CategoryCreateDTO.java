package com.wellness360.nutrition.dtos.category;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CategoryCreateDTO {
  
  private String name;
  private String description;
  private String image_url;

}
