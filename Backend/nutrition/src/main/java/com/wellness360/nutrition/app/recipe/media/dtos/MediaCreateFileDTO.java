package com.wellness360.nutrition.app.recipe.media.dtos;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;

@Getter
public class MediaCreateFileDTO {
  @NonNull
  String media;
}
