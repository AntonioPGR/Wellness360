package com.wellness360.nutrition.entities;

import java.util.Set;
import com.wellness360.nutrition.entities.base.NameNDescriptionBasedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "food")
public class FoodEntity extends NameNDescriptionBasedEntity {

  // ATRIBUTES
  @Column(name = "calories", nullable = false)
  private Short calories;

  @Column(name = "carbs", nullable = false)
  private Float carbs;

  @Column(name = "proteins", nullable = false)
  private Float proteins;

  @Column(name = "fats", nullable = false)
  private Float fats;

  @Column(name = "saturated_fats", nullable = false)
  private Float saturatedFats;

  @Column(name = "sodium", nullable = false)
  private Float sodium;

  @Column(name = "dietary_fiber", nullable = false)
  private Float dietaryFiber;

  @Column(name = "serving_amount", nullable = false)
  private Short servingAmount;

  // RELATIONSHIPS
  @ManyToOne
  @JoinColumn(name = "tag_id", referencedColumnName = "id", insertable = false, updatable = false)
  private TagEntity tag;

  @ManyToMany
  @JoinTable(
    name = "food_category",
    joinColumns = @JoinColumn(name="food_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Set<CategoryEntity> categories;

  @OneToMany(mappedBy = "food")
  private Set<RecipeEntity> recipes;

  @OneToMany(mappedBy = "food")
  private Set<PreferenceEntity> preferences;

  @OneToMany(mappedBy = "food")
  private Set<RestrictionEntity> restricions;
  

}

