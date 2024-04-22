package com.wellness360.nutrition.entities;

import java.util.Set;
import com.wellness360.nutrition.entities.base.NameNDescriptionBasedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Table(name = "recipes")
public class RecipeEntity extends NameNDescriptionBasedEntity {

  // ATTRIBUTES
  @Column(name = "post_user_id", nullable = false)
  private Long post_user_id;
  
  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "tag_id", referencedColumnName = "id", insertable = false, updatable = false)
  private TagEntity tag;
  
  @ManyToMany
  @JoinTable(
    name = "recipe_category",
    joinColumns = @JoinColumn(name="recipe_id"),
    inverseJoinColumns = @JoinColumn(name="category_id")
  )
  private Set<CategoryEntity> categories;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  private Set<FoodEntity> ingredients;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  private Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  private Set<RestrictionEntity> restricions;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  private Set<RecipeLogEntity> logs;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  private Set<RecipeMediaEntity> media;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  private Set<RecipeSectionEntity> sections;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "includedRecipe")
  private Set<RecipeSectionEntity> included_in_recipes;

  public RecipeEntity(String name, String description) {
    super(name, description);
  }

}

