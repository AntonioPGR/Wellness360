package com.wellness360.community.packages.storage.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.community.packages.crud.dtos.CrudCreateRequestDTO;

public abstract class CrudStorageCreateRequestDTO extends CrudCreateRequestDTO {

  public abstract MultipartFile getFile();
  public abstract String getName();

}
