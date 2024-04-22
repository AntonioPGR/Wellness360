package com.wellness360.nutrition.entities;

import java.util.Set;
import com.wellness360.nutrition.entities.base.NameNDescriptionBasedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "recipes")
public class RecipeEntity extends NameNDescriptionBasedEntity {

  // ATTRIBUTES
  @Column(name = "post_user_id", nullable = false)
  private Long postUserId;
  
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
  
  @OneToMany(mappedBy = "recipe")
  private Set<FoodEntity> ingredients;

  @OneToMany(mappedBy = "recipe")
  private Set<PreferenceEntity> preferences;

  @OneToMany(mappedBy = "recipe")
  private Set<RestrictionEntity> restricions;
  
  @OneToMany(mappedBy = "recipe")
  private Set<RecipeLogEntity> logs;

  @OneToMany(mappedBy = "recipe")
  private Set<RecipeMediaEntity> media;

  @OneToMany(mappedBy = "recipe")
  private Set<RecipeSectionEntity> sections;

  @OneToMany(mappedBy = "includedRecipe")
  private Set<RecipeSectionEntity> included_in_recipes;

}

