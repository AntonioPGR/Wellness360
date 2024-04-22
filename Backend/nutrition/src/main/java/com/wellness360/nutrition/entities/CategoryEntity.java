package com.wellness360.nutrition.entities;

import java.util.Set;

import com.wellness360.nutrition.dtos.category.CategoryCreateDTO;
import com.wellness360.nutrition.entities.base.NameNDescriptionBasedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Table(name = "categories")
public class CategoryEntity extends NameNDescriptionBasedEntity{

  // PROPERTIES
  @Column(name = "image_url", nullable = false, length = 150)
  private String image_url;
  
  // RELATIONSHIPS
  @ManyToMany(mappedBy = "categories")
  private Set<RecipeEntity> recipes;
  
  @ManyToMany(mappedBy = "categories")
  private Set<FoodEntity> food;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private Set<TagEntity> tags;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private Set<RestrictionEntity> restricions;

  // CONSTRUCTORS
  public CategoryEntity(CategoryCreateDTO dto) {
    super(
      dto.getName(), 
      dto.getDescription()
    );
    this.image_url = dto.getImage_url();
  }
}