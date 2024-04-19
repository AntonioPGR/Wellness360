package com.wellness360.nutrition.food;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.wellness360.nutrition.food.DTO.FoodCreateDTO;
import com.wellness360.nutrition.food.DTO.FoodUpdateDTO;
import com.wellness360.tools.MacroConversor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document(collection="Food")
public class FoodDocument {
  @Id
  private String id;
  private String name;
  private String description;
  private Integer calories;
  private Float carbs;
  private Float proteins;
  private Float fats;
  private Float saturated_fats;
  private Integer serving_amount;
  private Float sodium;
  private Float dietary_fibre;

  public FoodDocument(FoodCreateDTO create_dto){
    this.name = create_dto.name;
    this.description = create_dto.description;
    this.serving_amount = create_dto.serving_amount;
    this.carbs = macroConverter(create_dto.carbs);
    this.proteins = macroConverter(create_dto.proteins);
    this.fats = macroConverter(create_dto.fats);
    this.saturated_fats = macroConverter(create_dto.saturated_fats);
    this.dietary_fibre = macroConverter(create_dto.dietary_fibre);
    this.sodium = macroConverter(create_dto.sodium);
    this.calories = calculateCalories();
  }

  private Integer calculateCalories(){
    return Math.round((9 * this.fats) + 4 * (this.carbs + this.proteins));
  }

  private Float macroConverter(Float macro){
    return MacroConversor.macroRatioTo100g(macro, this.serving_amount);
  }

  @Override
  public String toString(){
    return String.format("Food[name=%s, calories=%d, serving amount=%f g]", this.name, this.calories, this,serving_amount);
  }

  public void update(FoodUpdateDTO dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

}
