package com.wellness360.exercises.packages.storage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("${path.storage}")
public class StorageController {

  @Autowired
  StorageService storage_service;
  
  @GetMapping("/{folder}/{file_name}")
  public ResponseEntity<InputStreamResource> getMethodName(@PathVariable("folder") String folder, @PathVariable("file_name") String file_name) throws IOException {
    String relative_path = folder + "/" + file_name;
    Resource resource = storage_service.loadAsResource(relative_path);
    return ResponseEntity.ok()
      .contentType(MediaType.IMAGE_JPEG)
      .body(new InputStreamResource(resource));
  }

}
