package com.wellness360.nutrition.app.selectivity.restriction;

import com.wellness360.nutrition.app.selectivity.SelectivityBaseEntity;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreatePersistenceDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restrictions")
@Setter
@Getter
@NoArgsConstructor
public class RestrictionEntity extends SelectivityBaseEntity {

  public RestrictionEntity(SelectivityCreatePersistenceDTO create_dto) {
    super(create_dto);
  }
  
}
