package com.wellness360.nutrition.entities;

import java.util.Set;
import com.wellness360.nutrition.entities.base.NameNDescriptionBasedEntity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "categories")
public class CategoryEntity extends NameNDescriptionBasedEntity{

  // PROPERTIES
  @Column(name = "image_url", nullable = false, length = 150)
  private String imageUrl;
  
  // RELATIONSHIPS
  @ManyToMany(mappedBy = "categories")
  private Set<RecipeEntity> recipes;
  
  @ManyToMany(mappedBy = "categories")
  private Set<FoodEntity> food;
  
  @OneToMany(mappedBy = "category")
  private Set<TagEntity> tags;

  @OneToMany(mappedBy = "category")
  private Set<PreferenceEntity> preferences;

  @OneToMany(mappedBy = "category")
  private Set<RestrictionEntity> restricions;

}