package com.wellness360.exercises.packages.storage.services;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.exercises.packages.storage.settings.StorageFolders;
import com.wellness360.exercises.packages.storage.settings.StorageProperties;
import com.wellness360.exercises.packages.storage.tools.FileUtils;
import com.wellness360.exercises.packages.storage.tools.StorageUtils;
import com.wellness360.exercises.packages.storage.validations.custom.StorageException;

@Service
public class StorageService {

  @Autowired
  private FileUtils file_utils;
  @Autowired
  private StorageProperties properties;

  private final Path root_location;
  private final String folder;

  public StorageService(StorageFolders folder_name){
    this.folder = folder_name.name();

    String location = properties.getLocation().trim();
    if(location.length() == 0) throw new StorageException("File upload location can not be Empty");
    this.root_location = Paths.get(location);
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
  public String store(MultipartFile file, String name) {
    file_utils.checkFileExists(file);
    String relative_path = file_utils.createFilePath(file, folder, name);
    Path absolute_path = StorageUtils.getAbsolutePath(relative_path, this.root_location);
    StorageUtils.checkDestinationPathIsInRoot(absolute_path, this.root_location);
    StorageUtils.storageFile(file, absolute_path);
    return properties.getFiles_api_url().concat(relative_path);
  }


  // LOAD
  public Path load(String path) {
    return root_location.resolve(path);
  }

  public Resource loadAsResource(String path) {
    Path file = load(path);
    return StorageUtils.getResourceFromPath(file);
  }


  // UPDATE
  public String update(MultipartFile file, String directory) {
    Resource old_file = loadAsResource(directory);
    StorageUtils.checkResourceExists(old_file);
    return store(file, directory);
  }


  // DELETE
  public void delete(String path) {
    Path absolute_path = StorageUtils.getAbsolutePath(path, root_location);
    FileSystemUtils.deleteRecursively(absolute_path.toFile());
  }

}
