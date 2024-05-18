package com.wellness360.nutrition.common.media_storage;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.common.media_storage.interfaces.IStorageService;
import com.wellness360.nutrition.exceptions.custom_exceptions.StorageException;

@Service
public class StorageService implements IStorageService {
  
  private final Path root_location;

  public StorageService(StorageProperties properties){
    if(properties.getLocation().trim().length() == 0){
      throw new StorageException("File upload location can not be Empty");
    }
    this.root_location = Paths.get(properties.getLocation());
  }

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

  public String createFilePath(String... dirs) {
    String dir_path = dirs[0];
    dirs = ArrayUtils.remove(dirs, 0);
    for(String dir : dirs){
      dir_path = dir_path.concat("/").concat(dir.toLowerCase().strip().replace(" ", "_"));
    }
    return dir_path;
  }

  public String store(MultipartFile file, String file_path) {
    StorageUtils.checkFileExists(file);
    String new_file_name = StorageUtils.normalizeFileName(file, file_path);
    Path destination_path = StorageUtils.getAbsolutePath(new_file_name, this.root_location);
    StorageUtils.checkDestinationPathIsInRoot(destination_path, this.root_location);
    StorageUtils.saveFile(file, destination_path);
    return "http://localhost:8080/files/".concat(new_file_name);
  }

  public Path load(String file_path) {
    return root_location.resolve(file_path);
  }

  public Resource loadAsResource(String file_path) {
    Path file = load(file_path);
    return StorageUtils.getResourceFromPath(file);
  }

  public String update(MultipartFile file, String file_dir) {
    Resource before_file = loadAsResource(file_dir);
    StorageUtils.checkResourceExists(before_file);
    return store(file, file_dir);
  }

  public void delete(String file_path) {
    Path absolue_path_webp = StorageUtils.getAbsolutePath(file_path+".webp", root_location);
    Path absolue_path_png = StorageUtils.getAbsolutePath(file_path+".png", root_location);
    Path absolue_path_jpg = StorageUtils.getAbsolutePath(file_path+".jpg", root_location);
    Path absolue_path_jpeg = StorageUtils.getAbsolutePath(file_path+".jpeg", root_location);
    FileSystemUtils.deleteRecursively(absolue_path_webp.toFile());
    FileSystemUtils.deleteRecursively(absolue_path_png.toFile());
    FileSystemUtils.deleteRecursively(absolue_path_jpg.toFile());
    FileSystemUtils.deleteRecursively(absolue_path_jpeg.toFile());
  }

}
