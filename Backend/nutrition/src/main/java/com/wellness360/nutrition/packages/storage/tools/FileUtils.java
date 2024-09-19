package com.wellness360.nutrition.packages.storage.tools;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.validation.ErrorsThrower;

public class FileUtils {

  public static void validateFile(MultipartFile file) {
    if(file.isEmpty()) ErrorsThrower.storageError("Failed to store empty faile.");
    String file_name = file.getOriginalFilename();
    if(file_name == null) ErrorsThrower.storageError("Could not read file without a name");
    Integer extension_index = file_name.lastIndexOf(".") + 1;
    if(extension_index == null || extension_index < 1) ErrorsThrower.storageError("Could not read file without an extension");
  }

  public static String createFilePath(MultipartFile file, String dir, String name) {
    String path = dir + "/" + name + "." + FileUtils.getFileExtension(file);
    return path;
  }

  public static String getFileExtension(MultipartFile file){
    String original_name = file.getOriginalFilename();
    Integer extension_index = original_name.lastIndexOf(".") + 1;
    if(extension_index == null || extension_index < 1) ErrorsThrower.storageError("Could not read file without an extension");
    return original_name.substring(extension_index);
  }

  public static String cleanPath(String name){
    return StringUtils.cleanPath(name)
      .strip()
      .toLowerCase()
      .replace(" ", "_");
  }

  public static String substituteExtension(String url, MultipartFile file) {
    String old_extension = url.substring(url.lastIndexOf(".") + 1);
    String new_extension = FileUtils.getFileExtension(file);
    return url.replace(old_extension, new_extension);
  }

  public static String substituteName(String url, String new_name) {
    String old_name = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
    return url.replace(old_name, new_name);
  }

}
