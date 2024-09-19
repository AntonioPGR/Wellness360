package com.wellness360.nutrition.packages.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.storage.settings.StorageProperties;
import com.wellness360.nutrition.packages.storage.tools.FileUtils;
import com.wellness360.nutrition.packages.storage.tools.StorageUtils;
import com.wellness360.nutrition.packages.storage.validations.custom.StorageException;

import jakarta.validation.ValidationException;

@Service
public class StorageService{

  private final StorageProperties properties;
  private Path root_location;

  public StorageService(StorageProperties properties){
    this.properties = properties;
    String location = properties.getLocation().trim();
    if(location.length() == 0) throw new StorageException("File upload location can not be Empty");
    this.root_location = Paths.get(location);
  }

  public <T extends Enum<T>> void init(Class<T> folders) {
    try{
      Files.createDirectories(root_location);
      for(T folder : folders.getEnumConstants()){
        Path new_folder = new File(root_location.toString(), folder.name()).toPath();
        Files.createDirectories(new_folder);
      }
    } catch ( IOException e ) {
      throw new StorageException("Could not initialize storage: ", e);
    }
  }

  public String store(MultipartFile file, String folder, String name) {
    FileUtils.validateFile(file);
    String relative_path = FileUtils.createFilePath(file, folder, name);
    return store(file, relative_path);
  }
  public String store(MultipartFile file, String relative_path) {
    FileUtils.validateFile(file);
    String cleaned_path = FileUtils.cleanPath(relative_path);
    Path absolute_path = StorageUtils.getAbsolutePath(cleaned_path, this.root_location);
    StorageUtils.storeFile(file, absolute_path);
    return properties.getUrl() + properties.getUrl_path() + "/" + cleaned_path;
  }

  // UPDATE
  public String update(MultipartFile file, String url) {
    FileUtils.validateFile(file);
    String cleaned_url = cleanUrl(url);
    Path file_path = getFilePath(cleaned_url);
    delete(file_path);
    String path = FileUtils.substituteExtension(cleaned_url, file);
    return store(file, path);
  }
  public String update(MultipartFile file, String url, String new_name) {
    FileUtils.validateFile(file);
    String cleaned_url = cleanUrl(url);
    Path file_path = getFilePath(cleaned_url);
    delete(file_path);

    String path = FileUtils.substituteExtension(cleaned_url, file);
    path = FileUtils.substituteName(cleaned_url, new_name);
    return store(file, path);
  }
  public String update(String url, String new_name) {
    String cleaned_url = cleanUrl(url);
    Path old_path = getFilePath(cleaned_url);
    Path new_path = getFilePath(FileUtils.substituteName(cleaned_url, FileUtils.cleanPath(new_name)));
    try{
      Files.move(old_path, new_path);
    } catch (Exception e){
      throw new ValidationException("Could not rename file!");
    }
    delete(old_path);
    return properties.getUrl() + properties.getUrl_path() + new_path.toString().replace(properties.getLocation(), "");
  }

  // DELETE
  public void delete(String url) {
    String cleaned_path = cleanUrl(url);
    Path path = getFilePath(cleaned_path);
    delete(path);
  }
  private void delete(Path path) {
    FileSystemUtils.deleteRecursively(path.toFile());
  }

  // GET
  public Resource getFile(String path) {
    Path file = getFilePath(path);
    Resource resource = StorageUtils.getResourceFromPath(file);
    StorageUtils.checkResourceExists(resource);
    return resource;
  }

  private Path getFilePath(String path) {
    return root_location.resolve(path);
  }

  private String cleanUrl(String url){
    if(!url.contains(properties.getUrl_path())) throw new ValidationException("Could not find image to delete");
    url = url.replace(properties.getUrl(), "").replace(properties.getUrl_path(), "");
    if(url.charAt(0) == '/') url = url.replaceFirst("/", "");
    url = FileUtils.cleanPath(url);
    return url;
  }

}
