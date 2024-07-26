package com.wellness360.community.app.posts;

import org.springframework.stereotype.Service;

import com.wellness360.community.app.posts.dto.PostCreatePersistenceDTO;
import com.wellness360.community.app.posts.dto.PostCreateRequestDTO;
import com.wellness360.community.app.posts.dto.PostReturnDTO;
import com.wellness360.community.app.posts.dto.PostUpdatePersistenceDTO;
import com.wellness360.community.app.posts.dto.PostUpdateRequestDTO;
import com.wellness360.community.packages.crud.service.CrudDtoTransformService;

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

  public PostReturnDTO getReturnDTO(PostEntity entity) {
    return new PostReturnDTO(entity);
  }

  public PostEntity getEntity(PostCreatePersistenceDTO dto) {
    return new PostEntity(dto);
  }

  public PostCreatePersistenceDTO getPersistenceCreateDTO(PostCreateRequestDTO request_dto) {
    return new PostCreatePersistenceDTO(request_dto);
  }

  public PostUpdatePersistenceDTO getPersistenceUpdateDTO(PostUpdateRequestDTO request_dto) {
    return new PostUpdatePersistenceDTO(request_dto);
  }

  public PostReturnDTO create(PostCreateRequestDTO request_dto) {
    // save media
  }

  @Override
  public PostReturnDTO update(PostUpdateRequestDTO request_dto) {
    // update media
  }

}
