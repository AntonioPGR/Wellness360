package com.wellness360.users.packages.crud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class NamedDescribedImageEntity extends UniqueIdentifierEntity {

  @Column(name = "name", unique = true, nullable = false, length = 50)
  public String name;

  @Column(name = "description", columnDefinition = "TEXT")
  public String description;

  @Column(name = "image_url", nullable = false, length = 150)
  public String image_url;

}
