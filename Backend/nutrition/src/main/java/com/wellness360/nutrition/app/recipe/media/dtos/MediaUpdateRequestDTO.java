package com.wellness360.nutrition.app.recipe.media.dtos;

import org.springframework.web.multipart.MultipartFile;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaUpdateRequestDTO {
  @NonNull
  String uuid;
  @NonNull
  MultipartFile media;
}