package com.wellness360.nutrition.app.selectivity;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreatePersistenceDTO;
import com.wellness360.nutrition.common.entities.UniqueIdentifierEntity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class SelectivityBaseEntity extends UniqueIdentifierEntity {

  @Column(name = "user_id", nullable = false)
  protected Long userId;
  
  @ManyToOne
  @JoinColumn(name = "recipe_id", nullable = true)
  protected RecipeEntity recipe;
  
  @ManyToOne
  @JoinColumn(name = "food_id", nullable = true)
  protected FoodEntity food;
  
  @ManyToOne
  @JoinColumn(name = "category_id", nullable = true)
  protected CategoryEntity category;

  public SelectivityBaseEntity(SelectivityCreatePersistenceDTO create_dto) {
    this.userId = 1L;
    this.food = create_dto.getFood();
    this.category = create_dto.getCategory();
    this.recipe = create_dto.getRecipe();
  }

}
