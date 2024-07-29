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
  String content;
  String replying_to;
  int visible;
  List<MultipartFile> media;

  public void validate(ValidateService validator) {
    validator.validateUuid(uuid);
    validator.validateText(content, true);
    validator.validateUuid(replying_to, true);
    validator.validateBoolean(visible, true);
    if(media != null) media.forEach((item) -> validator.validateMedia(item));
  }

}
