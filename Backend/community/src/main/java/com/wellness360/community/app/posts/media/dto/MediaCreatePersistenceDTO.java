package com.wellness360.community.app.posts.media.dto;

import com.wellness360.community.app.posts.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MediaCreatePersistenceDTO {

  String url;
  PostEntity post;
  
}
