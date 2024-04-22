package com.wellness360.nutrition.serializers;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class IngredientsKey implements Serializable {

  @Column
  Long food_id;

  @Column
  Long recipe_id;
  
}
