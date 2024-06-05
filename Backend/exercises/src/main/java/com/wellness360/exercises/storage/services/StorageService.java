package com.wellness360.exercises.storage.services;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.exercises.storage.settings.StorageFolders;
import com.wellness360.exercises.storage.settings.StorageProperties;
import com.wellness360.exercises.storage.tools.FileUtils;
import com.wellness360.exercises.storage.tools.StorageUtils;
import com.wellness360.exercises.storage.validations.custom.StorageException;

@Service
public class StorageService {
  
  // CONSTRUCTORS
  private final StorageProperties properties;
  private final Path root_location;
  public StorageService(StorageProperties properties){
    if(properties.getLocation().trim().length() == 0){
      throw new StorageException("File upload location can not be Empty");
    }
    this.root_location = Paths.get(properties.getLocation());
    this.properties = properties;
  }


  // INIT
  public void init() {
    try{
      Files.createDirectories(root_location);
      for(StorageFolders folder : StorageFolders.values()){
        Path new_folder = new File(root_location.toString(), folder.name()).toPath();
        Files.createDirectories(new_folder);
      }
    } catch ( IOException e ) {
      throw new StorageException("Could not initialize storage: ", e);
    }
  }


  // STORE
  public String store(MultipartFile file, String file_path) {
    FileUtils.checkFileExists(file);
    String new_file_name = FileUtils.normalizeFileName(file, file_path);
    Path destination_path = StorageUtils.getAbsolutePath(new_file_name, this.root_location);
    StorageUtils.checkDestinationPathIsInRoot(destination_path, this.root_location);
    StorageUtils.storageFile(file, destination_path);
    return "http://localhost:8080/files/".concat(new_file_name);
  }


  // LOAD
  public Path load(String file_path) {
    return root_location.resolve(file_path);
  }

  public Resource loadAsResource(String file_path) {
    Path file = load(file_path);
    return StorageUtils.getResourceFromPath(file);
  }


  // UPDATE
  public String update(MultipartFile file, String file_dir) {
    Resource before_file = loadAsResource(file_dir);
    StorageUtils.checkResourceExists(before_file);
    return store(file, file_dir);
  }


  // DELETE
  public void delete(String file_path) {
    List.of(properties.getImage_extensions()).forEach((str) -> {
      Path path = StorageUtils.getAbsolutePath(file_path+"."+str, root_location);
      FileSystemUtils.deleteRecursively(path.toFile());
    });
  }

}
