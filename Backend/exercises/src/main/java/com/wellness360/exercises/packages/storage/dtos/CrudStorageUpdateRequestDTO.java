package com.wellness360.exercises.packages.storage.dtos;

import org.springframework.web.multipart.MultipartFile;

import com.wellness360.exercises.packages.crud.dtos.CrudUpdateRequestDTO;

public abstract class CrudStorageUpdateRequestDTO extends CrudUpdateRequestDTO{

  public abstract MultipartFile getFile();
  public abstract String getName();

}