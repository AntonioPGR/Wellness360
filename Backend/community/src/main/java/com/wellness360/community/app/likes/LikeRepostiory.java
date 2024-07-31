package com.wellness360.community.app.likes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeRepostiory extends JpaRepository<LikeEntity, Long> {
  
  public long countByPost_id(Integer entity);

  public void deleteAllByPost_id(Integer id);

  @Modifying
  @Query(
    value = "DELETE FROM likes WHERE user_uuid = ?1 AND post_id = ?2",
    nativeQuery = true
  )
  public void deleteByUserAndPost(String user, Integer post);

}
