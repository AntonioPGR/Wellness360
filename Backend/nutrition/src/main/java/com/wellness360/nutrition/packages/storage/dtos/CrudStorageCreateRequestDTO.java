package com.wellness360.nutrition.packages.storage.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;

public abstract interface CrudStorageCreateRequestDTO extends CrudCreateRequestDTO {

  public abstract MultipartFile file();
  public abstract String name();

}
