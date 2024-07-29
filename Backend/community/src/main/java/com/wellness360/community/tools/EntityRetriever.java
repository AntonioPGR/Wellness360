package com.wellness360.community.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.community.app.posts.PostEntity;
import com.wellness360.community.app.posts.PostRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class EntityRetriever {

  @Autowired
  PostRepository post;

  public PostEntity getPost(String uuid){
    return post.findByUuid(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Could not find post with passed uuid"));
  }

}
