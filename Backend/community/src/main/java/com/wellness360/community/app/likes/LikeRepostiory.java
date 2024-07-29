package com.wellness360.community.app.likes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellness360.community.app.posts.PostEntity;

@Repository
public interface LikeRepostiory extends JpaRepository<LikeEntity, Long> {
  
  // @Query(
  //   value = "SELECT COUNT(l) FROM likes WHERE post_id = ?1",
  //   nativeQuery = true
  // )
  public long countByPost_id(PostEntity entity);

}
