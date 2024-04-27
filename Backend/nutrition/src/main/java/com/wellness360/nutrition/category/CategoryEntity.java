package com.wellness360.nutrition.category;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.wellness360.common.interfaces.CrudEntity;
import com.wellness360.nutrition.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.category.dtos.CategoryUpdateDTO;
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
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryEntity implements CrudEntity<CategoryUpdateDTO>{

  // CONSTRUCTORS
  public CategoryEntity(CategoryCreateDTO create_dto){
    this.setName(create_dto.getName());
    this.setDescription(create_dto.getDescription());
    this.setImage_url(create_dto.getImage_url());
  }

  // PROPERTIES
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private String uuid;

  @Column(name = "name", unique = true, nullable = false, length = 50)
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "image_url", nullable = false, length = 150)
  private String image_url;
  
  // RELATIONSHIPS
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private Set<RecipeEntity> recipes;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private Set<FoodEntity> food;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private Set<TagEntity> tags;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private Set<RestrictionEntity> restricions;

  // DEFAULT METHODS
  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID().toString();
    }
  }

  // METHODS
  @Override
  public void update(CategoryUpdateDTO update_dto) {
    this.name = Objects.requireNonNullElse(update_dto.getName(), this.getName());
    this.description = Objects.requireNonNullElse(update_dto.getDescription(), this.getDescription());
    this.image_url = Objects.requireNonNullElse(update_dto.getImage_url(), this.getImage_url());
  }

}