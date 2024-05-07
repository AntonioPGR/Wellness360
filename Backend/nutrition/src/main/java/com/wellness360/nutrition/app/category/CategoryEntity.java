package com.wellness360.nutrition.app.category;

import java.util.Objects;
import java.util.Set;

import com.wellness360.nutrition.common.entities.NamedDescribedImageEntity;
import com.wellness360.nutrition.common.interfaces.BaseEntity;
import com.wellness360.nutrition.app.category.dtos.CategoryCreateDTO;
import com.wellness360.nutrition.app.category.dtos.CategoryUpdateDTO;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.selectivity.preference.PreferenceEntity;
import com.wellness360.nutrition.app.selectivity.restriction.RestrictionEntity;
import com.wellness360.nutrition.app.tag.TagEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends NamedDescribedImageEntity implements BaseEntity<CategoryUpdateDTO>{

  // RELATIONSHIPS
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  protected Set<RecipeEntity> recipes;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  protected Set<FoodEntity> food;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  protected Set<TagEntity> tags;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  protected Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  protected Set<RestrictionEntity> restricions;

  // CONSTRUCTORS
  public CategoryEntity(CategoryCreateDTO create_dto){
    this.setName(create_dto.getName());
    this.setDescription(create_dto.getDescription());
    this.setImage_url(create_dto.getImage_url());
  }

  // INHERIT
  @Override
  public void update(CategoryUpdateDTO update_dto) {
    this.name = Objects.requireNonNullElse(update_dto.getName(), this.getName());
    this.description = Objects.requireNonNullElse(update_dto.getDescription(), this.getDescription());
    this.image_url = Objects.requireNonNullElse(update_dto.getImage_url(), this.getImage_url());
  }

}