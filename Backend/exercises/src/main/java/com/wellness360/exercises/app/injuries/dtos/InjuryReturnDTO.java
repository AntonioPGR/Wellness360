package com.wellness360.exercises.app.injuries.dtos;

import java.util.Date;

import com.wellness360.exercises.app.injuries.InjuryEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InjuryReturnDTO extends CrudReturnDTO {
  
  String uuid;
  String body_part;
  String description;
  Date initial_date;
  Date end_date;
  
  public InjuryReturnDTO(InjuryEntity entity) {
    this.uuid = entity.getUuid();
    this.body_part = entity.getBody_part();
    this.description = entity.getDescription();
    this.initial_date = entity.getInitial_date();
    this.end_date = entity.getEnd_date();
  }

}
