package com.wellness360.nutrition.app.selectivity.preference;

import com.wellness360.nutrition.app.selectivity.SelectivityBaseEntity;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateEntitiesDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "preferences")
@AllArgsConstructor
public class PreferenceEntity extends SelectivityBaseEntity {

  public PreferenceEntity(SelectivityCreateEntitiesDTO create_dto) {
    super(create_dto);
  }
  
}
