package com.wellness360.common.Entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@MappedSuperclass
@Getter
@EqualsAndHashCode
public abstract class BaseIdsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  protected String uuid;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID().toString();
    }
  }

}
