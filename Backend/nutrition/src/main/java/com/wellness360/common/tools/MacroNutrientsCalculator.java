package com.wellness360.common.tools;

public class MacroNutrientsCalculator {
  
  public static Short calculateCalories(Float carbs, Float proteins, Float fats){
    return (short) Math.round(
      (carbs * 4) + (proteins * 4) + (fats * 9)
    );
  }

  public static Float equalizeToNewAmount(Float macro_quantity, Float current_amount, Float equalize_amount){
    return macro_quantity * equalize_amount / current_amount;
  }

}
