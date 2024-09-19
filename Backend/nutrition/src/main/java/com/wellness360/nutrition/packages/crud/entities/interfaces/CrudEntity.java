package com.wellness360.nutrition.packages.crud.entities.interfaces;


public interface CrudEntity<UpdateDTO> {
  
  public abstract String getUuid();

  public abstract void update(UpdateDTO dto);

}
