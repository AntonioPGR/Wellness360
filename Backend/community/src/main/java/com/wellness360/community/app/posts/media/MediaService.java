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
      String path = storage_service.store(file, "posts");
      MediaEntity media_entity = new MediaEntity(path, post_entity);
      repository.saveAndFlush(media_entity);
      return path;
    }).toList();
    return media_list;
  }

  public List<String> update(List<MultipartFile> media, PostEntity post_entity) {
    List<String> media_list = media.stream().map((file) -> {
      post_entity.getMedia().forEach((old_file) -> {
        storage_service.delete(old_file.getUrl());
      });
      String path = storage_service.store(file, "posts");
      MediaEntity media_entity = new MediaEntity(path, post_entity);
      repository.saveAndFlush(media_entity);
      return path;
    }).toList();
    return media_list;
  }
  
}
