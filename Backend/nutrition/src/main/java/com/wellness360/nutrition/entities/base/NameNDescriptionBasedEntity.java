package com.wellness360.nutrition.entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Inheritance
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class NameNDescriptionBasedEntity extends IdNUuidBasedEntity {
  
  @Column(name = "name", unique = true, nullable = false, length = 50)
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

}
