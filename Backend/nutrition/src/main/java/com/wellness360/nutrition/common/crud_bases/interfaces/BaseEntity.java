package com.wellness360.nutrition.common.crud_bases.interfaces;

public interface BaseEntity<UpdateDTO> {
  
  public abstract String getUuid();

  public abstract void update(UpdateDTO dto);

}
