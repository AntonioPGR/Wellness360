package com.wellness360.community.app.posts.dto;

import com.wellness360.community.app.posts.PostEntity;
import com.wellness360.community.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdatePersistenceDTO extends CrudUpdatePersistenceDTO{

  String uuid;
  String user_uuid;
  String content;
  PostEntity replying_to;
  int visible;

  public PostUpdatePersistenceDTO(PostCreateRequestDTO request_dto, PostEntity replying_entity) {
    user_uuid = request_dto.getUser_uuid();
    content = replying_entity.getContent();
    replying_to = replying_entity;
    visible = request_dto.getVisible();
  }

}
