package com.wellness360.nutrition.entities;

import java.util.Set;

import com.wellness360.nutrition.entities.base.IdNUuidBasedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tags")
public class TagEntity extends IdNUuidBasedEntity {

  // ATTRIBUTES
  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "image_url", nullable = false, length = 150)
  private String image_url;

  // RELASHIONSHIPS
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id", insertable=false, updatable = false)
  private CategoryEntity category;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  private Set<FoodEntity> foods;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
  private Set<RecipeEntity> recipes;

}

