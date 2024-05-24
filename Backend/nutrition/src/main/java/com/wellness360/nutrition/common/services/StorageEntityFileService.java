package com.wellness360.nutrition.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class StorageEntityFileService{

  @Autowired
  protected StorageService storage_service;

  public String create(String name, String folder, MultipartFile image){
    String storage_path = createFilePath(name, folder);
    return storeFile(image, storage_path);
  }

  public String update(String name, String folder, MultipartFile image, String old_name) {
    if(image.isEmpty()) return null;

    delete(old_name, folder);
      
    String file_name = name != null? name : old_name;
    return create(file_name, folder, image);
  }

  public void delete(String name, String folder){
    String delete_file_path = createFilePath(name, folder);
    storage_service.delete(delete_file_path);
  }

  // METHODS
  private String createFilePath(String file_name, String folder_name){
    return storage_service.createFilePath(folder_name, file_name);
  }

  private String storeFile(MultipartFile file, String path){
    return storage_service.store(file, path);
  }
  
}
