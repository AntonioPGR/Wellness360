package com.wellness360.community.app.posts.dto;

import com.wellness360.community.app.posts.PostEntity;
import com.wellness360.community.packages.crud.dtos.CrudCreatePersistenceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreatePersistenceDTO extends CrudCreatePersistenceDTO {
  
  String user_uuid;
  String content;
  PostEntity replying_to;
  int visible;

  public PostCreatePersistenceDTO(PostCreateRequestDTO request_dto, PostEntity replying_entity) {
    user_uuid = request_dto.getUser_uuid();
    content = replying_entity.getContent();
    replying_to = replying_entity;
    visible = request_dto.getVisible();
  }

}
