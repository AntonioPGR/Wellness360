package com.wellness360.nutrition.entities;

import com.wellness360.nutrition.serializers.IngredientsKey;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Table(name = "recipes_ingredients")
public class RecipeIngredientEntity {
  
  @Embedded
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
