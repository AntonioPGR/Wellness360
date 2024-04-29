package com.wellness360.common.interfaces;

public interface BaseCrudEntities<UpdateDTO> {
  
  public abstract String getUuid();

  public abstract void update(UpdateDTO dto);

}
