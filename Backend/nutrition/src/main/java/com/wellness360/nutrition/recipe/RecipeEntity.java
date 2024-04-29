package com.wellness360.nutrition.recipe;

import java.util.Set;
import java.util.UUID;

import com.wellness360.common.Entities.BaseNameDescImgEntity;
import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.recipe.ingredients.RecipeIngredientEntity;
import com.wellness360.nutrition.recipe.logs.RecipeLogEntity;
import com.wellness360.nutrition.recipe.media.RecipeMediaEntity;
import com.wellness360.nutrition.recipe.section.RecipeSectionEntity;
import com.wellness360.nutrition.selectivity.preference.PreferenceEntity;
import com.wellness360.nutrition.selectivity.restriction.RestrictionEntity;
import com.wellness360.nutrition.tag.TagEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity extends BaseNameDescImgEntity{

  // ATTRIBUTES
  @Column(name = "post_user_id", nullable = false)
  private Long post_user_id;
  
  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "tag_id" )
  private TagEntity tag;
  
  @ManyToOne
  @JoinColumn(name = "category_id")
  @NonNull
  private CategoryEntity category;
  
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
      this.uuid = UUID.randomUUID().toString();
    }
  }

}

