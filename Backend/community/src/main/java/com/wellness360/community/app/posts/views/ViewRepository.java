package com.wellness360.community.app.posts.views;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellness360.community.app.posts.PostEntity;

public interface ViewRepository extends JpaRepository<ViewEntity, Long> {

  public long countByPost_id(PostEntity entity);

}
