package com.wellness360.nutrition.entities;

import com.wellness360.nutrition.entities.base.IdNUuidBasedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "recipes_sections")
public class RecipeSectionEntity extends IdNUuidBasedEntity {

  // ATTRIBUTES
  @Column(name = "text", nullable = false)
  private String text;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "recipe_id", referencedColumnName = "id", insertable = false, updatable = false)
  private RecipeEntity recipe;

  @ManyToOne
  @JoinColumn(name = "included_recipe", referencedColumnName = "id", insertable = false, updatable = false)
  private RecipeEntity included_recipe;

}

