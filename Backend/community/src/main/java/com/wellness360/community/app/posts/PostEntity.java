package com.wellness360.community.app.posts;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import com.wellness360.community.app.posts.dto.PostCreatePersistenceDTO;
import com.wellness360.community.app.posts.dto.PostUpdatePersistenceDTO;
import com.wellness360.community.app.posts.likes.LikeEntity;
import com.wellness360.community.app.posts.media.MediaEntity;
import com.wellness360.community.app.posts.views.ViewEntity;
import com.wellness360.community.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.community.packages.crud.entities.interfaces.ICrudEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
  PostEntity replying_to;
  String user_uuid;
  int visible;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  Date created_at;

  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  List<MediaEntity> media;

  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  List<ViewEntity> view;

  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  List<LikeEntity> like;

  public void update(PostUpdatePersistenceDTO dto) {
    content = Objects.requireNonNullElse(dto.getContent(), content);
    replying_to = Objects.requireNonNullElse(dto.getReplying_to(), replying_to);
    user_uuid = Objects.requireNonNullElse(dto.getUser_uuid(), user_uuid);
    visible = Objects.requireNonNullElse(dto.getVisible(), visible);
  }

  public PostEntity(PostCreatePersistenceDTO dto) {
    content = dto.getContent();
    replying_to = dto.getReplying_to();
    user_uuid = dto.getUser_uuid();
    visible = dto.getVisible();
  }

}
