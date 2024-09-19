package com.wellness360.nutrition.packages.storage.tools;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.storage.validations.custom.StorageFileNotFoundException;
import com.wellness360.nutrition.packages.validation.ErrorsThrower;

public class StorageUtils {
  
  public static void checkResourceExists(Resource resource){
    if(!resource.exists()) ErrorsThrower.fileNotFound("Update file does not exists");
  }

  public static Resource getResourceFromPath(Path file) {
    try{
      Resource resource = new UrlResource(file.toUri());
      if(resource.exists() || resource.isReadable() ) return resource; 
      throw new StorageFileNotFoundException("Could not read file: (Resource does not exist or is not readable) ");
    } catch (MalformedURLException e){
      throw new StorageFileNotFoundException("Could not read file: " + e.getMessage(), e);
    }
  }

  public static Path getAbsolutePath(String name, Path root_location){
    Path file_path = Paths.get(name);
    return root_location.resolve(file_path).normalize().toAbsolutePath();
  }

  public static void checkDestinationPathIsInRoot(Path destination_file, Path root_location){
    String destination_path = destination_file.getParent().toString();
    String root_path = root_location.toAbsolutePath().toString();

    if(!destination_path.contains(root_path)) ErrorsThrower.storageError("Cannot store file outside current directory");
  }

  public static void storeFile(MultipartFile file, Path destination_path){
    try {
      InputStream input_stream = file.getInputStream();
      Files.copy(input_stream, destination_path, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      ErrorsThrower.storageError("Failed to store file: " + e.getMessage());
    }
  }

}
