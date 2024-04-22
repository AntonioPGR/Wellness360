package com.wellness360.nutrition.entities.base;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.PrePersist;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Inheritance
@Entity
@Getter
@Setter
@EqualsAndHashCode
public abstract class IdNUuidBasedEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private UUID uuid;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID();
    }
  }

}
