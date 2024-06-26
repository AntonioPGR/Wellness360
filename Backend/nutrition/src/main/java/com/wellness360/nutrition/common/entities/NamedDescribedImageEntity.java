package com.wellness360.nutrition.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter(value = AccessLevel.PROTECTED)
public abstract class NamedDescribedImageEntity extends UniqueIdentifierEntity {

  @Column(name = "name", unique = true, nullable = false, length = 50)
  protected String name;

  @Column(name = "description", columnDefinition = "TEXT")
  protected String description;

  @Column(name = "image_url", nullable = false, length = 150)
  protected String image_url;

}
