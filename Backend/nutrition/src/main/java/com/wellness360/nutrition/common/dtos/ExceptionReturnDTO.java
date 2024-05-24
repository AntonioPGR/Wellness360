package com.wellness360.nutrition.common.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionReturnDTO {
  String message;

  public ExceptionReturnDTO(String message){
    this.message = message;
  }

}
