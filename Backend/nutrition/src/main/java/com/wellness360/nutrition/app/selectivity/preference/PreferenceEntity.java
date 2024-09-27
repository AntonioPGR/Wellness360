package com.wellness360.nutrition.app.selectivity.preference;

import com.wellness360.nutrition.app.selectivity.SelectivityBaseEntity;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreatePersistenceDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "preferences")
@AllArgsConstructor
@Setter
public class PreferenceEntity extends SelectivityBaseEntity {

  public PreferenceEntity(SelectivityCreatePersistenceDTO create_dto) {
    super(create_dto);
  }
  
}
