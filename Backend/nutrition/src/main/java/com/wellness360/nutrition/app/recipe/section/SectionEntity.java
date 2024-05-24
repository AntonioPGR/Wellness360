package com.wellness360.nutrition.app.recipe.section;

import java.util.Objects;

import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.section.dtos.SectionUpdatePersistenceDTO;
import com.wellness360.nutrition.common.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.common.interfaces.IBaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipes_sections")
@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class SectionEntity extends UniqueIdentifierEntity implements IBaseEntity<SectionUpdatePersistenceDTO>{

  @Column(name = "text", nullable = false)
  protected String text;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id" )
  protected RecipeEntity recipe;

  @ManyToOne
  @JoinColumn(name = "included_recipe" )
  protected RecipeEntity included_recipe;

  public SectionEntity(SectionCreatePersistenceDTO create_dto) {
    this.included_recipe = create_dto.getIncluded_recipe();
    this.text = create_dto.getText();
    this.recipe = create_dto.getRecipe();
  }

  @Override
  public void update(SectionUpdatePersistenceDTO dto) {
    this.text = Objects.requireNonNullElse(dto.getText(), this.text);
    this.recipe = Objects.requireNonNullElse(dto.getRecipe(), this.recipe);
    this.included_recipe = Objects.requireNonNullElse(dto.getIncluded_recipe(), this.included_recipe);
  }

}

