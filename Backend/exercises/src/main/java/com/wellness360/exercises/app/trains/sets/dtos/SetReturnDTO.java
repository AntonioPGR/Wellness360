package com.wellness360.exercises.app.trains.sets.dtos;

import com.wellness360.exercises.app.trains.sets.SetEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SetReturnDTO {
  
  String uuid;
  Integer weight;
  Integer reps;
  Integer minutes;

  public SetReturnDTO(SetEntity set) {
    uuid = set.getUuid();
    weight = set.getWeight() != null? set.getWeight().intValue() : null;
    reps = set.getReps() != null? set.getReps().intValue() : null;
    minutes = set.getMinutes() != null? set.getMinutes().intValue() : null;
  }

}
