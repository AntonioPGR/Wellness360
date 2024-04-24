package com.wellness360.nutrition.food;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class FoodController {
  
  @Autowired
  FoodService service;

  @GetMapping("/food")
  public String GET() {
      return "ola";
  }
  
}
