package com.wellness360.nutrition.app.selectivity;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.FoodEntity;
import com.wellness360.nutrition.app.recipe.RecipeEntity;
import com.wellness360.nutrition.app.selectivity.dtos.SelectivityCreatePersistenceDTO;
import com.wellness360.nutrition.packages.crud.entities.UniqueIdentifierEntity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class SelectivityBaseEntity extends UniqueIdentifierEntity {

  @Column(name = "user_uuid")
  String userUuid;
  
  @ManyToOne
  @JoinColumn(name = "recipe_id", nullable = true)
  RecipeEntity recipe;
  
  @ManyToOne
  @JoinColumn(name = "food_id", nullable = true)
  FoodEntity food;
  
  @ManyToOne
  @JoinColumn(name = "category_id", nullable = true)
  CategoryEntity category;

  public SelectivityBaseEntity(SelectivityCreatePersistenceDTO create_dto) {
    userUuid = create_dto.user_uuid();
    food = create_dto.food();
    category = create_dto.category();
    recipe = create_dto.recipe();
  }

}
