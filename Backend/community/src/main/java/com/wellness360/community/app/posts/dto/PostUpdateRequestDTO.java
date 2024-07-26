package com.wellness360.community.app.posts.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.community.packages.crud.dtos.CrudUpdateRequestDTO;
import com.wellness360.community.packages.validation.ValidateService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateRequestDTO extends CrudUpdateRequestDTO {

  String uuid;
  String user_uuid;
  String content;
  String replying_to;
  boolean visible;
  List<MultipartFile> media;

  public void validate(ValidateService validator) {
    a
  }

}
