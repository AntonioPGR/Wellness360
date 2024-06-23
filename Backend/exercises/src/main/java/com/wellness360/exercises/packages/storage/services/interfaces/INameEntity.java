package com.wellness360.exercises.packages.storage.services.interfaces;

import com.wellness360.exercises.packages.crud.entities.interfaces.IBaseEntity;

public interface INameEntity<UpdateDTO> extends IBaseEntity<UpdateDTO> {
  
  public abstract String getName();

}
