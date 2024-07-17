package com.wellness360.exercises.packages.storage.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("storage")
@Getter
@Setter
public class StorageProperties {
  
  @Value("${files.upload_dir}")
  private String location;

  @Value("${files.files_api_url}")
  private String files_api_url;

  @Value("${validation.image_extensions}")
  private String[] image_extensions;

}
