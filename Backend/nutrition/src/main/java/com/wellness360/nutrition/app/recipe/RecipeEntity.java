package com.wellness360.nutrition.app.recipe;

import java.util.Objects;
import java.util.Set;

import com.wellness360.nutrition.common.crud_bases.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.common.crud_bases.interfaces.BaseEntity;
import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.logs.LogEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;
import com.wellness360.nutrition.app.recipe.media.MediaEntity;
import com.wellness360.nutrition.app.recipe.section.SectionEntity;
import com.wellness360.nutrition.app.selectivity.preference.PreferenceEntity;
import com.wellness360.nutrition.app.selectivity.restriction.RestrictionEntity;
import com.wellness360.nutrition.app.tag.TagEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity extends UniqueIdentifierEntity implements BaseEntity<RecipeUpdatePersistenceDTO>{

  // ATTRIBUTES
  @Column(name = "name", unique = true, nullable = false, length = 50)
  protected String name;

  @Column(name = "description", columnDefinition = "TEXT")
  protected String description;

  @Column(name = "post_user_id", nullable = false)
  protected Long post_user_id;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "tag_id" )
  protected TagEntity tag;
  
  @ManyToOne
  @JoinColumn(name = "category_id")
  @NonNull
  protected CategoryEntity category;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  protected Set<IngredientEntity> ingredients;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  protected Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  protected Set<RestrictionEntity> restricions;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  protected Set<LogEntity> logs;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  protected Set<MediaEntity> media;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  protected Set<SectionEntity> sections;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "included_recipe")
  protected Set<SectionEntity> included_in_recipes;

  public RecipeEntity(RecipeCreatePersistenceDTO dto) {
    this.name = dto.getName();
    this.description = dto.getDescription();
    this.post_user_id = 1L;
    this.tag = dto.getTag();
    this.category = dto.getCategory();
    this.ingredients = dto.getIngredients();
    this.media = dto.getMedia();
    this.sections = dto.getSections();
  }

  @Override
  public void update(RecipeUpdatePersistenceDTO dto) {
    this.name = Objects.requireNonNullElse(dto.getName(), this.name);
    this.description = Objects.requireNonNullElse(dto.getDescription(), this.description);
    this.category = Objects.requireNonNullElse(dto.getCategory(), this.category);
    this.tag = Objects.requireNonNullElse(dto.getTag(), this.tag);
  }


}

