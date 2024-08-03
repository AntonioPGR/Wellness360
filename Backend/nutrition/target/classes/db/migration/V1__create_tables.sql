-- CATEGORIES
CREATE TABLE IF NOT EXISTS categories (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  name VARCHAR(50) UNIQUE NOT NULL,
  description TEXT,
  image_url VARCHAR(150) NOT NULL
);
CREATE INDEX idx_uuid ON categories (uuid);

-- TAGS
CREATE TABLE IF NOT EXISTS tags (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  category_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  image_url VARCHAR(150) NOT NULL,
  FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);
CREATE INDEX idx_uuid ON tags (uuid);

-- FOOD
CREATE TABLE IF NOT EXISTS food (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  category_id INT NOT NULL,
  tag_id INT,
  name VARCHAR(50) UNIQUE NOT NULL,
  description TEXT,
  image_url VARCHAR(150) NOT NULL,
  serving_amount SMALLINT NOT NULL DEFAULT 100,
  calories DECIMAL(8,2) NOT NULL,
  carbs DECIMAL(8,2) NOT NULL,
  proteins DECIMAL(8,2) NOT NULL,
  fats DECIMAL(8,2) NOT NULL,
  saturated_fats DECIMAL(8,2) NOT NULL,
  sodium DECIMAL(8,2) NOT NULL,
  dietary_fiber DECIMAL(8,2) NOT NULL,
  FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE,
  FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE
);
CREATE INDEX idx_uuid ON food (uuid);

-- RECIPES
CREATE TABLE IF NOT EXISTS recipes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  tag_id INT,
  post_user_id INT NOT NULL,
  category_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE SET NULL,
  FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);
CREATE INDEX idx_uuid ON recipes (uuid);

CREATE TABLE IF NOT EXISTS recipes_log (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  recipe_id INT NOT NULL,
  user_id INT NOT NULL,
  date DATE NOT NULL,
  FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE
);
CREATE INDEX idx_uuid ON recipes_log (uuid);

CREATE TABLE IF NOT EXISTS recipes_media (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  recipe_id INT NOT NULL,
  media_url VARCHAR(150) NOT NULL,
  FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE
);
CREATE INDEX idx_uuid ON recipes_media (uuid);

CREATE TABLE IF NOT EXISTS recipes_sections (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  recipe_id INT NOT NULL,
  text TEXT NOT NULL,
  included_recipe INT,
  FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE,
  FOREIGN KEY (included_recipe) REFERENCES recipes(id) ON DELETE CASCADE
);
CREATE INDEX idx_uuid ON recipes_sections (uuid);

CREATE TABLE IF NOT EXISTS recipes_ingredients(
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  recipe_id INT NOT NULL,
  food_id INT NOT NULL,
  amount SMALLINT NOT NULL,
  FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE,
  FOREIGN KEY (food_id) REFERENCES food(id) ON DELETE CASCADE
);

-- RESTRICTIONS
CREATE TABLE IF NOT EXISTS restrictions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  user_id INT,
  recipe_id INT,
  food_id INT,
  category_id INT,
  FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE,
  FOREIGN KEY (food_id) REFERENCES food(id) ON DELETE CASCADE,
  FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);
CREATE INDEX idx_uuid ON restrictions (uuid);

-- PREFERENCES
CREATE TABLE IF NOT EXISTS preferences (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  user_id INT,
  recipe_id INT,
  food_id INT,
  category_id INT,
  FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE,
  FOREIGN KEY (food_id) REFERENCES food(id) ON DELETE CASCADE,
  FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);
CREATE INDEX idx_uuid ON preferences (uuid);
