package com.wellness360.nutrition.app.recipe.media.dtos;

import com.wellness360.nutrition.app.recipe.media.MediaEntity;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;

@Getter
public class MediaReturnDTO {
  @NonNull
  String uuid;
  @NonNull
  String media_url;

  public MediaReturnDTO(MediaEntity entity){
    uuid = entity.getUuid();
    media_url = entity.getMedia_url();
  }

}