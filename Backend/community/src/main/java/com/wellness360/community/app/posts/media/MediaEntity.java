package com.wellness360.community.app.posts.media;

import com.wellness360.community.app.posts.PostEntity;
import com.wellness360.community.packages.crud.entities.UniqueIdentifierEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "media")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MediaEntity extends UniqueIdentifierEntity{
  
  String url;
  
  @ManyToOne
  @JoinColumn(name = "post_id")
  PostEntity post;

}
