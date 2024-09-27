package com.wellness360.nutrition.app.recipe.ingredient;

import java.util.Objects;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.packages.crud.entities.interfaces.CrudEntity;

import jakarta.persistence.*;
import lombok.*;

@Data 
@EqualsAndHashCode(callSuper=false)
@Table(name = "recipes_ingredients")
@Entity
public class IngredientEntity extends UniqueIdentifierEntity implements CrudEntity<IngredientUpdatePersistenceDTO>{
  
  @ManyToOne
  @JoinColumn(name= "food_id")
  FoodEntity food;

  @ManyToOne
  @JoinColumn(name="recipe_id")
  RecipeEntity recipe;

  @Column(name = "amount", nullable = false)
  Short amount;

  public void update(IngredientUpdatePersistenceDTO dto) {
    food =  Objects.requireNonNullElse(dto.food(), food);
    recipe = Objects.requireNonNullElse(dto.recipe(), recipe);
    amount = Objects.requireNonNullElse(dto.amount(), amount);
  }

}
