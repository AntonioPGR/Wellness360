package com.wellness360.community.app.posts.views;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ViewRepository extends JpaRepository<ViewEntity, Long> {

  public long countByPost_id(Integer entity);

  public void deleteAllByPost_id(Integer id);

}
