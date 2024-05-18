package com.wellness360.nutrition.app.tag;

import java.util.Objects;
import java.util.Set;

import com.wellness360.nutrition.common.crud_bases.entities.NamedDescribedImageEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.BaseEntity;
import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.tag.dtos.TagCreatePersistenceDTO;
import com.wellness360.nutrition.app.tag.dtos.TagUpdatePersistenceDTO;

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
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity extends NamedDescribedImageEntity implements BaseEntity<TagUpdatePersistenceDTO>{
  
  // RELASHIONSHIPS
  @ManyToOne
  @JoinColumn(name = "category_id", nullable=false)
  protected CategoryEntity category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  protected Set<FoodEntity> foods;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  protected Set<RecipeEntity> recipes;

  // CONSTRUCTORS
  public TagEntity(TagCreatePersistenceDTO dto) {
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.image_url = dto.getImage_url();
    this.category = dto.getCategory();
  }

  // INHERIT
  @Override
  public void update(TagUpdatePersistenceDTO dto) {
    this.name = Objects.requireNonNullElse(dto.getName(), this.name);
    this.description = Objects.requireNonNullElse(dto.getDescription(), this.description);
    this.image_url = Objects.requireNonNullElse(dto.getImage_url(), this.image_url);
    this.category = Objects.requireNonNullElse(dto.getCategory(), this.category);
  }

}

