package com.wellness360.community.app.posts.views;

import com.wellness360.community.app.posts.PostEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "views")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ViewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  
  String user_uuid;

  @ManyToOne
  @JoinColumn(name = "post_id")
  PostEntity post;

}
