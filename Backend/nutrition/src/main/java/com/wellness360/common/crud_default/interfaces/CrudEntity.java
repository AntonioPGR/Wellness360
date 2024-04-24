package com.wellness360.common.crud_default.interfaces;

public interface CrudEntity<UpdateDTO> {
  
  abstract String getUuid();

  abstract void update(UpdateDTO dto);

}
