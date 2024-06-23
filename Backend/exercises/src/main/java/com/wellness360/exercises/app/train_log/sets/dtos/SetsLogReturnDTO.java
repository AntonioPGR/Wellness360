package com.wellness360.exercises.app.train_log.sets.dtos;

import com.wellness360.exercises.app.train_log.sets.SetLogEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;

import lombok.Getter;

@Getter
public class SetsLogReturnDTO extends CrudReturnDTO {

  String uuid;
  Integer weight;
  Integer reps;
  Integer minutes;
  
  public SetsLogReturnDTO(SetLogEntity set) {
    uuid = set.getUuid();
    weight = set.getWeight().intValue();
    reps = set.getReps().intValue();
    minutes = set.getMinutes().intValue();
  }

}
