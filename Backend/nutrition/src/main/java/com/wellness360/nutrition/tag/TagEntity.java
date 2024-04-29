package com.wellness360.nutrition.tag;

import java.util.Objects;
import java.util.Set;
import com.wellness360.common.Entities.BaseNameDescImgEntity;
import com.wellness360.common.interfaces.BaseCrudEntities;
import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.food.FoodEntity;
import com.wellness360.nutrition.recipe.RecipeEntity;
import com.wellness360.nutrition.tag.dtos.TagCreateEntitiesDTO;
import com.wellness360.nutrition.tag.dtos.TagUpdateEntitiesDTO;
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
public class TagEntity extends BaseNameDescImgEntity implements BaseCrudEntities<TagUpdateEntitiesDTO>{
  
  // RELASHIONSHIPS
  @ManyToOne
  @JoinColumn(name = "category_id", nullable=false)
  protected CategoryEntity category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  protected Set<FoodEntity> foods;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  protected Set<RecipeEntity> recipes;

  // CONSTRUCTORS
  public TagEntity(TagCreateEntitiesDTO dto) {
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.image_url = dto.getImage_url();
    this.category = dto.getCategory();
  }

  // INHERIT
  @Override
  public void update(TagUpdateEntitiesDTO dto) {
    this.name = Objects.requireNonNullElse(dto.getName(), this.name);
    this.description = Objects.requireNonNullElse(dto.getDescription(), this.description);
    this.image_url = Objects.requireNonNullElse(dto.getImage_url(), this.image_url);
    this.category = Objects.requireNonNullElse(dto.getCategory(), this.category);
  }

}

