package com.wellness360.nutrition.category;

import java.util.Set;
import java.util.UUID;

import com.wellness360.nutrition.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.food.FoodEntity;
import com.wellness360.nutrition.preference.PreferenceEntity;
import com.wellness360.nutrition.recipe.RecipeEntity;
import com.wellness360.nutrition.restriction.RestrictionEntity;
import com.wellness360.nutrition.tag.TagEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryEntity{

  // CONSTRUCTORS
  public CategoryEntity(CategoryCreateDTO create_dto){
    this.setName(create_dto.getName());
    this.setDescription(create_dto.getDescription());
    this.setImage_url(create_dto.getImage_url());
  }

  // PROPERTIES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private UUID uuid;

  @Column(name = "name", unique = true, nullable = false, length = 50)
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

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

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID();
    }
  }

}