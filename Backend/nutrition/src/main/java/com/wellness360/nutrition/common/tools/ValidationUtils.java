package com.wellness360.nutrition.common.tools;

import java.util.Arrays;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ValidationUtils {

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

  public boolean isImageExtensionSupported(MultipartFile file, String[] supported_extensions) {
    String file_extension = FileUtils.getFileExtension(file);
    return Arrays.asList(supported_extensions).contains(file_extension);
  }

  public boolean isImageBiggerThanInMb(MultipartFile file, Integer max_size) {
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
  


}
