package com.wellness360.users.packages.storage.tools;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.users.packages.validation.ErrorsThrower;

@Service
public class FileUtils {

  public String createFilePath(MultipartFile file, String dir, String name) {
    String path = concatNameAndDir(dir, name);
    String path_with_extension = concatPathAndExtension(path, file);
    return path_with_extension;
  }

  public void checkFileExists(MultipartFile file){
    if(file.isEmpty()) ErrorsThrower.storageError("Failed to store empty faile.");
  }

  // PRIVATE
  private String concatNameAndDir(String dir, String name){
    dir = cleanName(dir);
    name = cleanName(name);
    return dir.concat("/").concat(name);
  }

  private String concatPathAndExtension(String path, MultipartFile file){
    String extension = getFileExtension(file);
    return path.concat(".").concat(extension);
  }
  
  public String getFileExtension(MultipartFile file){
    String original_name = getOriginalFileName(file);
    Integer extension_index = original_name.lastIndexOf(".") + 1;
    if(extension_index == null || extension_index < 1) ErrorsThrower.storageError("Could not read file without an extension");
    return original_name.substring(extension_index);
  }

  private String getOriginalFileName(MultipartFile file){
    String name = file.getOriginalFilename();
    if(name == null) ErrorsThrower.storageError("Could not read file without a name");
    return name;
  }

  private String cleanName(String name){
    return StringUtils.cleanPath(name)
      .strip()
      .toLowerCase()
      .replace(" ", "_");
  }

}
