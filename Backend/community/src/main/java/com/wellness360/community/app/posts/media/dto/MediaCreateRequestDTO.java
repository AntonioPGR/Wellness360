package com.wellness360.community.app.posts.media.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MediaCreateRequestDTO {

  MultipartFile file;
  String post_uuid;
  
}
