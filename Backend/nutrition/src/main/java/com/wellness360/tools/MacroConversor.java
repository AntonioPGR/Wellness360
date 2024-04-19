package com.wellness360.tools;

import java.text.DecimalFormat;

public class MacroConversor {

  public static Float macroRatioTo100g(Float macro_quantity, Integer serving_amount){
    Float ratio = macro_quantity * 100 / serving_amount;
    DecimalFormat two_places_formatter = new DecimalFormat("#.##");
    return Float.valueOf(two_places_formatter.format(ratio));
  }
  
}
