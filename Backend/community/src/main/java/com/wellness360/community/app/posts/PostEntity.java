package com.wellness360.community.app.posts;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


import com.wellness360.community.app.likes.LikeEntity;
import com.wellness360.community.app.posts.dto.PostCreatePersistenceDTO;
import com.wellness360.community.app.posts.dto.PostUpdatePersistenceDTO;
import com.wellness360.community.app.posts.media.MediaEntity;
import com.wellness360.community.app.posts.views.ViewEntity;
import com.wellness360.community.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.community.packages.crud.entities.interfaces.ICrudEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity extends UniqueIdentifierEntity implements ICrudEntity<PostUpdatePersistenceDTO> {
  
  String content;
  String user_uuid;
  int visible;
  Date created_at;

  @ManyToOne
  @JoinColumn(name = "replying_to")
  PostEntity replying_to;

  @OneToMany(mappedBy = "post")
  List<MediaEntity> media;

  @OneToMany(mappedBy = "post")
  List<ViewEntity> view;

  @OneToMany(mappedBy = "post")
  List<LikeEntity> like;

  public void update(PostUpdatePersistenceDTO dto) {
    content = Objects.requireNonNullElse(dto.getContent(), content);
    replying_to = Objects.requireNonNullElse(dto.getReplying_to(), replying_to);
    visible = Objects.requireNonNullElse(dto.getVisible(), visible);
  }

  public PostEntity(PostCreatePersistenceDTO dto) {
    content = dto.getContent();
    replying_to = dto.getReplying_to();
    user_uuid = dto.getUser_uuid();
    visible = dto.getVisible();
    created_at = Date.valueOf(LocalDate.now());
  }

}
