package com.wellness360.nutrition.app.recipe.ingredient;

import java.util.Objects;

import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientCreatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.dto.IngredientUpdatePersistenceDTO;
import com.wellness360.nutrition.common.entities.UniqueIdentifierEntity;
import com.wellness360.nutrition.common.interfaces.IBaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(value = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipes_ingredients")
@Entity
public class IngredientEntity extends UniqueIdentifierEntity implements IBaseEntity<IngredientUpdatePersistenceDTO>{
  
  @ManyToOne
  @JoinColumn(name= "food_id")
  protected FoodEntity food;

  @ManyToOne
  @JoinColumn(name="recipe_id")
  protected RecipeEntity recipe;

  @Column(name = "amount", nullable = false)
  protected Short amount;

  public IngredientEntity(IngredientCreatePersistenceDTO dto){
    this.food = dto.getFood();
    this.recipe = dto.getRecipe();
    this.amount = dto.getAmount().shortValue();
  }

  public void update(IngredientUpdatePersistenceDTO dto) {
    this.food =  Objects.requireNonNullElse(dto.getFood(), this.food);
    this.recipe = Objects.requireNonNullElse(dto.getRecipe(), this.recipe);
    this.amount = Objects.requireNonNullElse(dto.getAmount(), this.amount);
  }

}
