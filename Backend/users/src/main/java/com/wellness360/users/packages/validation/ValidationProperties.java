package com.wellness360.users.packages.validation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("validation")
@Getter
@Setter
public class ValidationProperties {

  // IMAGES
  @Value("${validation.image_extensions}")
  private String[] image_extensions;
  @Value("${validation.image_size}")
  private Integer image_size;
  

  // VIDEOS
  @Value("${validation.video_extensions}")
  private String[] video_extensions;
  @Value("${validation.video_size}")
  private Integer video_size;

  @Value("${validation.name_lenght}")
  private int max_name_lenght;
  @Value("${validation.text_lenght}")
  private int max_text_lenght;

}
