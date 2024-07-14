package com.wellness360.exercises.app.train_log.sets.dtos;

import com.wellness360.exercises.app.train_log.sets.SetLogEntity;
import com.wellness360.exercises.packages.crud.dtos.CrudReturnDTO;

import lombok.Getter;

@Getter
public class SetLogReturnDTO extends CrudReturnDTO {

  String uuid;
  Integer weight;
  Integer reps;
  Integer minutes;
  
  public SetLogReturnDTO(SetLogEntity set) {
    uuid = set.getUuid();
    weight = set.getWeight() != null? set.getWeight().intValue() : null;
    reps = set.getReps() != null? set.getReps().intValue() : null;
    minutes = set.getMinutes() != null? set.getMinutes().intValue() : null;
  }

}
