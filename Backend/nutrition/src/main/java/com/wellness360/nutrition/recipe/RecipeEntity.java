package com.wellness360.nutrition.recipe;

import java.util.Set;
import java.util.UUID;

import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.food.FoodEntity;
import com.wellness360.nutrition.preference.PreferenceEntity;
import com.wellness360.nutrition.restriction.RestrictionEntity;
import com.wellness360.nutrition.tag.TagEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RecipeEntity{

  // ATTRIBUTES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private UUID uuid;

  @Column(name = "name", unique = true, nullable = false, length = 50)
  protected String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "post_user_id", nullable = false)
  private Long post_user_id;
  
  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "tag_id",   insertable = false, updatable = false)
  private TagEntity tag;
  
  @ManyToMany
  @JoinTable(
    name = "recipe_category",
    joinColumns = @JoinColumn(name="recipe_id"),
    inverseJoinColumns = @JoinColumn(name="category_id")
  )
  private Set<CategoryEntity> categories;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
  private Set<RecipeIngredientEntity> ingredients;

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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "included_recipe")
  private Set<RecipeSectionEntity> included_in_recipes;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID();
    }
  }

}

