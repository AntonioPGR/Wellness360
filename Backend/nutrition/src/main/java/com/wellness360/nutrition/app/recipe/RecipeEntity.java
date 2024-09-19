package com.wellness360.nutrition.app.recipe;

import java.util.Objects;
import java.util.Set;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.logs.LogEntity;
import com.wellness360.nutrition.app.recipe.dtos.RecipeUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;
import com.wellness360.nutrition.app.recipe.media.MediaEntity;
import com.wellness360.nutrition.app.recipe.section.SectionEntity;
import com.wellness360.nutrition.app.selectivity.preference.PreferenceEntity;
import com.wellness360.nutrition.app.selectivity.restriction.RestrictionEntity;
import com.wellness360.nutrition.app.tag.TagEntity;
import com.wellness360.nutrition.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity extends UniqueIdentifierEntity implements CrudEntity<RecipeUpdatePersistenceDTO>{

  // ATTRIBUTES
  @Column(name = "name", unique = true, nullable = false, length = 50)
  String name;

  @Column(name = "description", columnDefinition = "TEXT")
  String description;

  @Column(name = "post_user_uuid", nullable = false)
  String post_user_uuid;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "tag_id" )
  TagEntity tag;
  
  @ManyToOne
  @JoinColumn(name = "category_id")
  @NonNull
  CategoryEntity category;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  Set<IngredientEntity> ingredients;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  Set<RestrictionEntity> restricions;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  Set<LogEntity> logs;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  Set<MediaEntity> media;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  Set<SectionEntity> sections;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "included_recipe")
  Set<SectionEntity> included_in_recipes;

  @Override
  public void update(RecipeUpdatePersistenceDTO dto) {
    name = Objects.requireNonNullElse(dto.name(), name);
    description = Objects.requireNonNullElse(dto.description(), description);
    category = Objects.requireNonNullElse(dto.category(), category);
    tag = Objects.requireNonNullElse(dto.tag(), tag);
  }

}

