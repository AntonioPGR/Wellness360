package com.wellness360.nutrition.restriction;

import java.util.UUID;

import com.wellness360.nutrition.category.CategoryEntity;
import com.wellness360.nutrition.food.FoodEntity;
import com.wellness360.nutrition.recipe.RecipeEntity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restrictions")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RestrictionEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "uuid", unique = true, nullable = false, length = 36)
  private UUID uuid;

  @Column(name = "user_id")
  private Long userId;
  
  @ManyToOne
  @JoinColumn(name = "recipe_id",   insertable = false, updatable = false)
  private RecipeEntity recipe;
  
  @ManyToOne
  @JoinColumn(name = "food_id",   insertable = false, updatable = false)
  private FoodEntity food;
  
  @ManyToOne
  @JoinColumn(name = "category_id",   insertable = false, updatable = false)
  private CategoryEntity category;

  @PrePersist
  private void initializeUUID(){
    if(this.uuid == null){
      this.uuid = UUID.randomUUID();
    }
  }

}

