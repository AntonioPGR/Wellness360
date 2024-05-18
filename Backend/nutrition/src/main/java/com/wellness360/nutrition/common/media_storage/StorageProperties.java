package com.wellness360.nutrition.common.media_storage;

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

}
