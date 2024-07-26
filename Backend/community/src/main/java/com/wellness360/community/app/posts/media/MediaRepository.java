package com.wellness360.community.app.posts.media;

import org.springframework.stereotype.Repository;

import com.wellness360.community.packages.crud.repositories.CrudRepository;

@Repository
public interface MediaRepository extends CrudRepository<MediaEntity>  {
  
}
