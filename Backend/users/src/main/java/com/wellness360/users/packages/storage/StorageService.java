package com.wellness360.users.packages.storage;


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

import com.wellness360.users.packages.storage.settings.StorageFolders;
import com.wellness360.users.packages.storage.settings.StorageProperties;
import com.wellness360.users.packages.storage.tools.FileUtils;
import com.wellness360.users.packages.storage.tools.StorageUtils;
import com.wellness360.users.packages.storage.validations.custom.StorageException;
import com.wellness360.users.packages.validation.ErrorsThrower;

import jakarta.validation.ValidationException;

@Service
public class StorageService {

  @Autowired
  private FileUtils file_utils;

  private final StorageProperties properties;
  private final Path root_location;

  public StorageService(StorageProperties properties){
    this.properties = properties;
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
  public String store(MultipartFile file, String folder, String name) {
    file_utils.checkFileExists(file);
    String relative_path = file_utils.createFilePath(file, folder, name);
    return store(file, relative_path);
  }
  public String store(MultipartFile file, String relative_path) {
    file_utils.checkFileExists(file);
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
  public String update(MultipartFile file, String image_url) {
    if(!image_url.contains(properties.getFiles_api_url())) throw new ValidationException("Could not find image to delete");
    String path = image_url.replace(properties.getFiles_api_url(), "");
    Resource old_file = loadAsResource(path);
    StorageUtils.checkResourceExists(old_file);
    delete(image_url);

    Integer extension_index = path.lastIndexOf(".") + 1;
    if(extension_index == null || extension_index < 1) ErrorsThrower.storageError("Could not read file without an extension");
    String old_extension = path.substring(extension_index);
    String new_extension = file_utils.getFileExtension(file);
    path = path.replace(old_extension, new_extension);
    return store(file, path);
  }


  // DELETE
  public void delete(String image_url) {
    if(!image_url.contains(properties.getFiles_api_url())) throw new ValidationException("Could not find image to delete");
    String path = image_url.replace(properties.getFiles_api_url(), "");
    Path absolute_path = StorageUtils.getAbsolutePath(path, root_location);
    FileSystemUtils.deleteRecursively(absolute_path.toFile());
  }



}
