package com.wellness360.common.tools;

public class MacroNutrientsCalculator {
  
  protected Short current_amount;
  protected Short equalize_amount;

  public MacroNutrientsCalculator(Short current_amount, Short equalize_amount){
    this.current_amount = current_amount;
    this.equalize_amount = equalize_amount;
  }

  public Float equalizeToNewAmount(Float macro_quantity){
    return macro_quantity * this.equalize_amount / this.current_amount;
  }

  public static Short calculateCalories(Float carbs, Float proteins, Float fats){
    return (short) Math.round(
      (carbs * 4) + (proteins * 4) + (fats * 9)
    );
  }

}
