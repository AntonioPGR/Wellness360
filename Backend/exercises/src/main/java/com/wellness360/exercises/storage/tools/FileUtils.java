package com.wellness360.exercises.storage.tools;

import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.exercises.validation.ErrorsThrower;

public class FileUtils {
  
  public static String getFileExtension(MultipartFile file){
    String original_name = getOriginalFileName(file);
    Integer extension_index = original_name.lastIndexOf(".") + 1;
    if(extension_index == null || extension_index < 1) ErrorsThrower.storageError("Could not read file without an extension");
    return original_name.substring(extension_index);
  }

  public static String getOriginalFileName(MultipartFile file){
    String name = file.getOriginalFilename();
    if(name == null) ErrorsThrower.storageError("Could not read file without a name");
    return name;
  }

  public static String normalizeFileName(MultipartFile file, String new_file_name){
    String new_name = StringUtils.cleanPath(new_file_name)
      .trim()
      .toLowerCase()
      .replace(" ", "_");

    String file_extension = getFileExtension(file);

    return new_name.concat(".").concat(file_extension);
  }

  public static void checkFileExists(MultipartFile file){
    if(file.isEmpty()){
      ErrorsThrower.storageError("Failed to store empty faile.");
    }
  }

  public static String createFilePath(String... dirs) {
    String dir_path = dirs[0];
    List<String> directory_list = List.of(dirs);
    directory_list.remove(0);
    for(String dir : directory_list){
      dir_path = dir_path.concat("/").concat(dir.toLowerCase().strip().replace(" ", "_"));
    }
    return dir_path;
  }

}
