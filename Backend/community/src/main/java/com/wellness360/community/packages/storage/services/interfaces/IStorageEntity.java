package com.wellness360.community.packages.storage.services.interfaces;

import com.wellness360.community.packages.crud.entities.interfaces.ICrudEntity;

public interface IStorageEntity<UpdateDTO> extends ICrudEntity<UpdateDTO> {
  
  abstract String getImage_url();

  abstract void setImage_url(String image_url);

}
