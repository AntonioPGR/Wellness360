package com.wellness360.nutrition.app.recipe.ingredient.dto;

import com.wellness360.nutrition.packages.crud.dtos.CrudCreateRequestDTO;
import com.wellness360.nutrition.validation.Validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientCreateRequestDTO implements CrudCreateRequestDTO {
    
  private String food_uuid;
  private int amount;

  public void validate(Validator validator) {
    validator.string.validateUuid(food_uuid);
    validator.number.validateShort(amount);
  }
}
