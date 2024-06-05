package com.wellness360.exercises.crud.interfaces;

public interface IBaseEntity<UpdateDTO> {
  
  public abstract String getUuid();

  public abstract void update(UpdateDTO dto);

}
