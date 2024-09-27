package com.wellness360.nutrition.app.recipe.section;

import java.util.Objects;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_sections")
@Data 
@EqualsAndHashCode(callSuper=false)
public class SectionEntity extends UniqueIdentifierEntity implements CrudEntity<SectionUpdatePersistenceDTO>{

  @Column(name = "text", nullable = false)
  String text;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id" )
  RecipeEntity recipe;

  @ManyToOne
  @JoinColumn(name = "included_recipe" )
  RecipeEntity included_recipe;

  public void update(SectionUpdatePersistenceDTO dto) {
    text = Objects.requireNonNullElse(dto.text(), text);
    recipe = Objects.requireNonNullElse(dto.recipe(), recipe);
    included_recipe = Objects.requireNonNullElse(dto.included_recipe(), included_recipe);
  }

}

