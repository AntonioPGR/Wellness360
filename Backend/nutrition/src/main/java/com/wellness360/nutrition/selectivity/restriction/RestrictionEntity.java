package com.wellness360.nutrition.selectivity.restriction;

import com.wellness360.nutrition.selectivity.SelectivityBaseEntity;
import com.wellness360.nutrition.selectivity.dtos.SelectivityCreateEntitiesDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "restrictions")
public class RestrictionEntity extends SelectivityBaseEntity {

  public RestrictionEntity(SelectivityCreateEntitiesDTO create_dto) {
    super(create_dto);
  }
  
}
