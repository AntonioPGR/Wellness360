DROP TABLE food_category;
ALTER TABLE food
ADD category_id INT NOT NULL;
ALTER TABLE food
ADD FOREIGN KEY (category_id) REFERENCES categories(id);

DROP TABLE recipe_category;
ALTER TABLE recipes
ADD category_id INT NOT NULL;
ALTER TABLE recipes
ADD FOREIGN KEY (category_id) REFERENCES categories(id);