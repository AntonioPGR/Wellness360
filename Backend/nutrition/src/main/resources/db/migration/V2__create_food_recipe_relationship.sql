CREATE TABLE IF NOT EXISTS recipes_ingredients(
  recipe_id INT NOT NULL,
  food_id INT NOT NULL,
  PRIMARY KEY (recipe_id, food_id),
  FOREIGN KEY (recipe_id) REFERENCES recipes(id),
  FOREIGN KEY (food_id) REFERENCES food(id)
)