package com.wellness360.nutrition.app.category;

import java.util.Optional;
import java.util.Set;
import com.wellness360.nutrition.app.category.dtos.CategoryUpdatePersistenceDTO;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.selectivity.preference.PreferenceEntity;
import com.wellness360.nutrition.app.selectivity.restriction.RestrictionEntity;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.packages.crud.entities.NamedDescribedImageEntity;
import com.wellness360.nutrition.packages.storage.services.interfaces.StorageEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends NamedDescribedImageEntity implements StorageEntity<CategoryUpdatePersistenceDTO>{

  // RELATIONSHIPS
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  Set<RecipeEntity> recipes;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  Set<FoodEntity> food;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  Set<TagEntity> tags;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  Set<RestrictionEntity> restricions;

  public void update(CategoryUpdatePersistenceDTO dto) {
    name = Optional.ofNullable(dto.name()).orElse(name);
    description = Optional.ofNullable(dto.description()).orElse(description);
    image_url = Optional.ofNullable(dto.image_url()).orElse(image_url);
  }

}