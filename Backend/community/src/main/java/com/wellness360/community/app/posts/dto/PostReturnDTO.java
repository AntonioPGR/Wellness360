package com.wellness360.community.app.posts.dto;

import java.util.List;

import com.wellness360.community.app.posts.PostEntity;
import com.wellness360.community.packages.crud.dtos.CrudReturnDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostReturnDTO extends CrudReturnDTO {

  String uuid;
  String user_uuid;
  String content;
  String replying_to;
  int visible;
  long views;
  long likes;
  List<String> media;
  
  public PostReturnDTO(PostEntity entity) {
    this.uuid = entity.getUuid();
    this.user_uuid = entity.getUser_uuid();
    this.content = entity.getContent();
    this.replying_to = entity.getReplying_to().getUuid();
    this.visible = entity.getVisible();
  }

}
