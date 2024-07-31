package com.wellness360.community.app.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.community.app.likes.dtos.LikeCreateDTO;
import com.wellness360.community.app.likes.dtos.LikeReturnDTO;
import com.wellness360.community.app.posts.PostEntity;
import com.wellness360.community.tools.EntityRetriever;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LikeService {
  
  @Autowired
  LikeRepostiory repostiory;
  @Autowired
  EntityRetriever entity_retriever;

  public long getNumberOf(PostEntity entity){
    return repostiory.countByPost_id(entity.getId());
  }

  public LikeReturnDTO create(LikeCreateDTO dto) {
    PostEntity post = entity_retriever.getPost(dto.getPost_uuid());
    LikeEntity entity = new LikeEntity(dto, post);
    repostiory.saveAndFlush(entity);
    return new LikeReturnDTO(repostiory.countByPost_id(post.getId()));
  }

  public void deleteAllByPost(PostEntity entity) {
    repostiory.deleteAllByPost_id(entity.getId());
  }

  public void deleteByUserAndPost(String post_uuid, String user){
    PostEntity post = entity_retriever.getPost(post_uuid);
    repostiory.deleteByUserAndPost(user, post.getId());
  }

}
