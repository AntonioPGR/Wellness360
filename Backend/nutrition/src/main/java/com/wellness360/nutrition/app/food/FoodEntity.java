package com.wellness360.nutrition.app.food;

import java.util.Optional;
import java.util.Set;

import com.wellness360.nutrition.app.category.CategoryEntity;
import com.wellness360.nutrition.app.food.dtos.FoodUpdatePersistenceDTO;
import com.wellness360.nutrition.app.recipe.ingredient.IngredientEntity;
import com.wellness360.nutrition.app.selectivity.preference.PreferenceEntity;
import com.wellness360.nutrition.app.selectivity.restriction.RestrictionEntity;
import com.wellness360.nutrition.packages.crud.entities.NamedDescribedImageEntity;
import com.wellness360.nutrition.packages.storage.services.interfaces.StorageEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntity extends NamedDescribedImageEntity implements StorageEntity<FoodUpdatePersistenceDTO>{

  // COLUMNS
  @Column(name = "calories", nullable = false)
  Float calories;

  @Column(name = "carbs", nullable = false)
  Float carbs;

  @Column(name = "proteins", nullable = false)
  Float proteins;

  @Column(name = "fats", nullable = false)
  Float fats;

  @Column(name = "saturated_fats", nullable = false)
  Float saturated_fats;

  @Column(name = "sodium", nullable = false)
  Float sodium;

  @Column(name = "dietary_fiber", nullable = false)
  Float dietary_fiber;

  @Column(name = "serving_amount", nullable = false)
  Short serving_amount = 100;

  @ManyToOne
  @JoinColumn(name = "category_id")
  CategoryEntity category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  Set<IngredientEntity> recipes;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  Set<PreferenceEntity> preferences;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
  Set<RestrictionEntity> restricions;

  public void update(FoodUpdatePersistenceDTO dto) {
    name = Optional.ofNullable(dto.name()).orElse(name);
    description = Optional.ofNullable(dto.description()).orElse(description);
    carbs = Optional.ofNullable(dto.nutrients().getCarbs()).orElse(carbs);
    proteins = Optional.ofNullable(dto.nutrients().getProteins()).orElse(proteins);
    fats = Optional.ofNullable(dto.nutrients().getFats()).orElse(fats);
    saturated_fats = Optional.ofNullable(dto.nutrients().getSaturated_fats()).orElse(saturated_fats);
    sodium = Optional.ofNullable(dto.nutrients().getSodium()).orElse(sodium);
    dietary_fiber = Optional.ofNullable(dto.nutrients().getDietary_fiber()).orElse(dietary_fiber);
    serving_amount = Optional.ofNullable(dto.nutrients().getServing_amount()).orElse(serving_amount);
    image_url = Optional.ofNullable(dto.image_url()).orElse(image_url);
    calculateCalories();
  }

  void calculateCalories(){
    this.calories = 4 * carbs + 4 * proteins + 9 * fats;
  }
  
}

