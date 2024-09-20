package com.wellness360.users.packages.validation;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellness360.users.packages.storage.tools.FileUtils;

@Service
public class ValidationUtils {

  @Autowired
  FileUtils file_utils;

  public boolean isNullOrEmpty(String obj) {
    return this.isNull(obj) || this.isEmpty(obj);
  }

  public boolean hasNumbers(String string) {
    return string.matches(".*\\d.*");
  }

  public boolean hasSymbols(String string) {
    String regex = "[^a-zA-Z0-9 ]";
    return string.matches(".*" + regex + ".*");
  }

  public boolean isLengthGreaterThan(String string, Integer max_length) {
    return string.length() > max_length;
  }

  public boolean isNull(Object obj) {
    return obj == null;
  }

  public boolean isEmpty(String string) {
    return string == "";
  }

  public boolean isMediaExtensionSupported(MultipartFile file, String[] supported_extensions) {
    String file_extension = file_utils.getFileExtension(file);
    return Arrays.asList(supported_extensions).contains(file_extension);
  }

  public boolean isMediaBiggerThanInMb(MultipartFile file, Integer max_size) {
    Double bytes_multiplier = 0.00000095367432;
    return file.getSize() * bytes_multiplier > max_size;
  }

  public boolean isLengthDifferentFrom(String uuid, int i) {
    return uuid.length() != i;
  }

  public boolean isUuidValid(String uuid) {
    String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    return uuid.matches(regex);
  }

  public boolean isBoolean(int bool){
    return bool != 0 && bool != 1;
  }

  public boolean isNullableAndNull(boolean nullable, Object obj){
    return nullable && isNull(obj);
  }

  
  
}
