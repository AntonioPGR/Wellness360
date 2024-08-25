package com.wellness360.users.packages.storage.settings;

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
  private String[] allowed_image_extensions;
  @Value("${validation.video_extensions}")
  private String[] allowed_video_extensions;

  @Value("${validation.image_size}")
  private int max_image_size;
  @Value("${validation.video_size}")
  private int max_video_size;

}
