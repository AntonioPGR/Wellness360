package com.wellness360.users.packages.storage.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.users.packages.crud.dtos.CrudCreateRequestDTO;

public abstract interface CrudStorageCreateRequestDTO extends CrudCreateRequestDTO {

  public abstract MultipartFile getFile();
  public abstract String getName();

}
