package com.wellness360.nutrition.packages.storage.services.interfaces;

import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;

public interface StorageEntity<UpdateDTO> extends CrudEntity<UpdateDTO> {
  
  abstract String getImage_url();

  abstract void setImage_url(String image_url);

}
