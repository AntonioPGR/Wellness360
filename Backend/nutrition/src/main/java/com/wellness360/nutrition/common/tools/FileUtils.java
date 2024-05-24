package com.wellness360.nutrition.common.tools;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.exceptions.custom.StorageException;

public class FileUtils {
  
  public static String getFileExtension(MultipartFile file){
    String original_name = file.getOriginalFilename();
    if(original_name == null) throw new StorageException("Could not read file without an extension");
    return original_name.substring(original_name.lastIndexOf(".") + 1);
  }

}
