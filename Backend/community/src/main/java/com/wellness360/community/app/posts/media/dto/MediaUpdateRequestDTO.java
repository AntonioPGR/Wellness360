package com.wellness360.community.app.posts.media.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MediaUpdateRequestDTO {

  MultipartFile file;
  String old_url;
  String post_uuid;
  
}
