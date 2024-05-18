package com.wellness360.nutrition.common.media_storage.interfaces;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
  
  void init();

  String createFilePath(String... dirs);

  String store(MultipartFile file, String file_path);

  String update(MultipartFile file, String file_path);

  Path load(String file_path);

  Resource loadAsResource(String file_path);

  void delete(String file_path);



}
