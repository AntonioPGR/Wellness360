package com.wellness360.community.app.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellness360.community.app.likes.LikeService;
import com.wellness360.community.app.posts.dto.PostCreatePersistenceDTO;
import com.wellness360.community.app.posts.dto.PostCreateRequestDTO;
import com.wellness360.community.app.posts.dto.PostReturnDTO;
import com.wellness360.community.app.posts.dto.PostUpdatePersistenceDTO;
import com.wellness360.community.app.posts.dto.PostUpdateRequestDTO;
import com.wellness360.community.app.posts.media.MediaService;
import com.wellness360.community.app.posts.views.ViewService;
import com.wellness360.community.packages.crud.service.CrudDtoTransformService;
import com.wellness360.community.packages.storage.StorageService;
import com.wellness360.community.tools.EntityRetriever;

@Service
public class PostService extends CrudDtoTransformService<
  PostRepository,
  PostCreateRequestDTO,
  PostCreatePersistenceDTO,
  PostUpdateRequestDTO,
  PostUpdatePersistenceDTO,
  PostReturnDTO,
  PostEntity
>{

  @Autowired
  EntityRetriever entity_retriever;
  @Autowired
  StorageService storage_service;
  @Autowired
  LikeService like_service;
  @Autowired
  ViewService view_service;
  @Autowired
  MediaService media_service;

  public PostReturnDTO getReturnDTO(PostEntity entity) {
    PostReturnDTO return_dto = new PostReturnDTO(entity);

    long likes = like_service.getNumberOf(entity);
    return_dto.setLikes(likes);

    long views = view_service.getNumberOf(entity);
    return_dto.setViews(views);

    return return_dto;
  }

  public PostEntity getEntity(PostCreatePersistenceDTO dto) {
    return new PostEntity(dto);
  }

  public PostCreatePersistenceDTO getPersistenceCreateDTO(PostCreateRequestDTO request_dto) {
    PostEntity replying_post = null;
    String replying_to = request_dto.getReplying_to();
    if(replying_to != null) replying_post = entity_retriever.getPost(replying_to);
    return new PostCreatePersistenceDTO(request_dto, replying_post);
  }

  public PostUpdatePersistenceDTO getPersistenceUpdateDTO(PostUpdateRequestDTO request_dto) {
    PostEntity replying_post = null;
    String replying_to = request_dto.getReplying_to();
    if(replying_to != null) replying_post = entity_retriever.getPost(replying_to);
    return new PostUpdatePersistenceDTO(request_dto, replying_post);
  }

  public PostReturnDTO create(PostCreateRequestDTO request_dto) {
    PostReturnDTO return_dto = super.create(request_dto);

    PostEntity entity = entity_retriever.getPost(return_dto.getUuid());
    List<String> media_list = media_service.create(request_dto.getMedia(), entity);

    return_dto = getReturnDTO(entity);
    return_dto.setMedia(media_list);
    return return_dto;
  }

  public PostReturnDTO update(PostUpdateRequestDTO request_dto) {
    PostReturnDTO return_dto = super.update(request_dto);

    PostEntity entity = entity_retriever.getPost(return_dto.getUuid());
    List<String> media_list = media_service.update(request_dto.getMedia(), entity);

    return_dto = getReturnDTO(entity);
    return_dto.setMedia(media_list);
    return return_dto;
  }

  public void delete(String uuid) {
    PostEntity entity = entity_retriever.getPost(uuid);
    like_service.deleteAllByPost(entity);
    media_service.deleteAllByPost(entity);
    view_service.deleteAllByPost(entity);
    super.delete(uuid);
  }

}
