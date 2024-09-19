package com.wellness360.nutrition.packages.validation.validators;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.validation.ErrorsThrower;
import com.wellness360.nutrition.packages.validation.ValidationServiceBase;
import com.wellness360.nutrition.packages.validation.ValidationUtils;

@Service
public class MediaValidator extends ValidationServiceBase {

  @Autowired
  ValidationUtils utils;

  public void validateImage(MultipartFile image){
    validateImage(image, false);
  }
  public void validateImage(MultipartFile image, Boolean nullable) {
    String label = "Image"; 
    if(utils.isNullableAndNull(nullable, image)) return;
    validateNotNull(image, label);
    if(!utils.isMediaExtensionSupported(image, properties.getImage_extensions())) ErrorsThrower.validationError(label + " unsuported type");
    if(utils.isMediaBiggerThanInMb(image, properties.getImage_size())) ErrorsThrower.validationError(label + " size is large than allowed");
  }

  public void validateMedia(MultipartFile media){
    validateMedia(media, false);
  }
  public void validateMedia(MultipartFile media, boolean nullable){
    String label = "Media";
    if(utils.isNullableAndNull(nullable, media)) return;
    validateNotNull(media, label);

    Stream<String> video_extensions = Stream.of(properties.getVideo_extensions());
    Stream<String> image_extensions = Stream.of(properties.getImage_extensions());
    String[] media_extensions = (String[]) Stream.concat(video_extensions, image_extensions).toArray();
    if(!utils.isMediaExtensionSupported(media, media_extensions)) ErrorsThrower.validationError(label + " unsuported type");
  }


  public void validateVideo(MultipartFile video) {
    validateVideo(video, false);
  }
  public void validateVideo(MultipartFile video, boolean nullable) {
    String label = "Video"; 
    if(utils.isNullableAndNull(nullable, video)) return;
    validateNotNull(video, label);
    if(!utils.isMediaExtensionSupported(video, properties.getVideo_extensions())) ErrorsThrower.validationError(label + " unsuported type");
    if(utils.isMediaBiggerThanInMb(video, properties.getVideo_size())) ErrorsThrower.validationError(label + " size is large than allowed");
  }
  
}
