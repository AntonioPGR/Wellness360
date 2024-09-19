package com.wellness360.nutrition.packages.storage.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.nutrition.packages.crud.dtos.CrudUpdateRequestDTO;

public abstract interface CrudStorageUpdateRequestDTO extends CrudUpdateRequestDTO{

  public abstract MultipartFile file();
  public abstract String name();

}
