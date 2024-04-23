package com.wellness360.nutrition.recipe;

import com.wellness360.nutrition.food.FoodEntity;
import com.wellness360.nutrition.recipe.serializers.IngredientsKey;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Table(name = "recipes_ingredients")
@Entity
public class RecipeIngredientEntity{
  
  @EmbeddedId
  private IngredientsKey id;

  @ManyToOne
  @MapsId("food_id")
  @JoinColumn(name= "food_id")
  private FoodEntity food;

  @ManyToOne
  @MapsId("recipe_id")
  @JoinColumn(name="recipe_id")
  private RecipeEntity recipe;

  private Short amount;

}
