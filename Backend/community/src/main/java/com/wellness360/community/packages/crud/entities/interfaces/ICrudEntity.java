package com.wellness360.community.packages.crud.entities.interfaces;


public interface ICrudEntity<UpdateDTO> {
  
  public abstract String getUuid();

  public abstract void update(UpdateDTO dto);

}
