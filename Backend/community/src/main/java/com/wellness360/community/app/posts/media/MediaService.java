package com.wellness360.community.app.posts.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.community.app.posts.PostEntity;
import com.wellness360.community.packages.storage.StorageService;

@Service
public class MediaService {

  @Autowired
  StorageService storage_service;
  @Autowired
  MediaRepository repository;

  public List<String> create(List<MultipartFile> media, PostEntity post_entity) {
    List<String> media_list = media.stream().map((file) -> {
      String path = storage_service.store(file, "posts", post_entity.getUuid()+file.hashCode());
      MediaEntity media_entity = new MediaEntity(path, post_entity);
      repository.saveAndFlush(media_entity);
      return path;
    }).toList();
    return media_list;
  }

  public List<String> update(List<MultipartFile> media, PostEntity post_entity) {
    post_entity.getMedia().forEach((old_media) -> {
      storage_service.delete(old_media.getUrl());
      repository.delete(old_media);
    });
    return create(media, post_entity);
  }

  public void deleteAllByPost(PostEntity entity) {
    entity.getMedia().stream().forEach((media) -> storage_service.delete(media.getUrl()));
    repository.deleteAllByPost_id(entity.getId());
  }
  
}
