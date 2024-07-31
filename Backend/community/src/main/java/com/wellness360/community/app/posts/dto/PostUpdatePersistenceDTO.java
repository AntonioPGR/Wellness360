package com.wellness360.community.app.posts.dto;

import com.wellness360.community.app.posts.PostEntity;
import com.wellness360.community.packages.crud.dtos.CrudUpdatePersistenceDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdatePersistenceDTO extends CrudUpdatePersistenceDTO{

  String uuid;
  String content;
  PostEntity replying_to;
  int visible;

  public PostUpdatePersistenceDTO(PostUpdateRequestDTO request_dto, PostEntity replying_entity) {
    content = request_dto.getContent();
    replying_to = replying_entity;
    visible = request_dto.getVisible();
  }

}
