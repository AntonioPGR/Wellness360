package com.wellness360.nutrition.common.media_storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.exceptions.custom_exceptions.StorageException;
import com.wellness360.nutrition.exceptions.custom_exceptions.StorageFileNotFoundException;

public class StorageUtils {
  
  static String normalizeFileName(MultipartFile file, String new_file_name){
    String new_name = StringUtils.cleanPath(new_file_name)
      .trim()
      .toLowerCase()
      .replace(" ", "_");

    String original_name = file.getOriginalFilename();
    if(original_name == null) throw new StorageException("Could not read file without an extension");
    String file_extension = original_name.substring(original_name.lastIndexOf(".") + 1);

    return new_name.concat(".").concat(file_extension);
  }

  static void checkFileExists(MultipartFile file){
    if(file.isEmpty()){
      throw new StorageException("Failed to store empty faile.");
    }
  }

  static void checkResourceExists(Resource resource){
    if(!resource.exists()) throw new StorageFileNotFoundException("Update file does not exists");
  }

  static Path getAbsolutePath(String name, Path root_location){
    Path file_path = Paths.get(name);
    return root_location.resolve(file_path).normalize().toAbsolutePath();
  }

  static void checkDestinationPathIsInRoot(Path destination_file, Path root_location){
    String destination_path = destination_file.getParent().toString();
    String root_path = root_location.toAbsolutePath().toString();
    if(!destination_path.contains(root_path)){
      throw new StorageException("Cannot store file outside current directory");
    }
  }

  static void saveFile(MultipartFile file, Path destination_path){
    try {
      InputStream input_stream = file.getInputStream();
      Files.copy(input_stream, destination_path, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      throw new StorageException("Failed to store file: " + e.getMessage(), e);
    }
  }

  public static Resource getResourceFromPath(Path file) {
    try{
      Resource resource = new UrlResource(file.toUri());
      if(resource.exists() || resource.isReadable() ) return resource; 
      throw new StorageFileNotFoundException("Could not read file: (Resource does not exist or is not readeble) ");
    } catch (MalformedURLException e){
      throw new StorageFileNotFoundException("Could not read file: " + e.getMessage(), e);
    }
  }

}
