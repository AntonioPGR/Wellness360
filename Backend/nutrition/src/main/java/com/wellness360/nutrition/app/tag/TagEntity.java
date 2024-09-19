package com.wellness360.nutrition.app.tag;

import java.util.Optional;
import java.util.Set;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.tag.dtos.TagUpdatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.entities.NamedDescribedImageEntity;
import com.wellness360.nutrition.packages.storage.services.interfaces.StorageEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity extends NamedDescribedImageEntity implements StorageEntity<TagUpdatePersistenceDTO> {
  
  // RELASHIONSHIPS
  @ManyToOne
  @JoinColumn(name = "category_id", nullable=false)
  CategoryEntity category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  Set<FoodEntity> foods;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  Set<RecipeEntity> recipes;

  // INHERIT
  @Override
  public void update(TagUpdatePersistenceDTO dto) {
    name = Optional.ofNullable(dto.name()).orElse(name);
    description = Optional.ofNullable(dto.description()).orElse(description);
    image_url = Optional.ofNullable(dto.image_url()).orElse(image_url);
    category = Optional.ofNullable(dto.category()).orElse(category);
  }

}

