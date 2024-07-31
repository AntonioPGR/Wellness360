package com.wellness360.community.app.posts.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.community.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.community.packages.validation.ValidateService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequestDTO extends CrudCreateRequestDTO {

  String user_uuid;
  String content;
  String replying_to;
  List<MultipartFile> media;

  public void validate(ValidateService validator) {
    validator.validateUuid(user_uuid);
    validator.validateText(content);
    validator.validateUuid(replying_to, true);
    media.forEach((item) -> validator.validateMedia(item));
  }

}
  