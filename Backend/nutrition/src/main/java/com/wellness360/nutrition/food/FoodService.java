package com.wellness360.nutrition.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

  @Autowired
  FoodRepository repository;

}
