package com.wellness360.exercises.packages.crud.entities.interfaces;


public interface IBaseEntity<UpdateDTO> {
  
  public abstract String getUuid();

  public abstract void update(UpdateDTO dto);

}
