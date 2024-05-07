package com.wellness360.nutrition.common.interfaces;

public interface BaseEntity<UpdateDTO> {
  
  public abstract String getUuid();

  public abstract void update(UpdateDTO dto);

}
