package com.wellness360.community.app.posts.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.community.app.posts.PostEntity;

@Service
public class ViewService {

  @Autowired
  ViewRepository repository;

  public long getNumberOf(PostEntity entity) {
    return repository.countByPost_id(entity);
  }
  
}
