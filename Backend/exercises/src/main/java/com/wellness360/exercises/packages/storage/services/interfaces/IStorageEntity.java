package com.wellness360.exercises.packages.storage.services.interfaces;

import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;

public interface IStorageEntity<UpdateDTO> extends IBaseEntity<UpdateDTO> {
  
  abstract String getImage_url();

  abstract void setImage_url(String image_url);

}
