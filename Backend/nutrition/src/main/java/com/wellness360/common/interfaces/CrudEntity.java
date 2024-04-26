package com.wellness360.common.interfaces;

public interface CrudEntity<UpdateDTO> {
  
  abstract String getUuid();

  abstract void update(UpdateDTO dto);

}
