package com.wellness360.nutrition.app.selectivity.preference;

import com.wellness360.nutrition.app.selectivity.SelectivityBaseEntity;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreateEntitiesDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "preferences")
public class PreferenceEntity extends SelectivityBaseEntity {

  public PreferenceEntity(SelectivityCreateEntitiesDTO create_dto) {
    super(create_dto);
  }
  
}
