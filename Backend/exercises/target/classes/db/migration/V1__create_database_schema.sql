-- ASIDE TABLES
CREATE TABLE body_focus(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  body_part VARCHAR(25) UNIQUE NOT NULL,
  user_uuid CHAR(36) NOT NULL,
  priority TINYINT DEFAULT 2,
  PRIMARY KEY (id)
);

CREATE TABLE injuries(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  body_part VARCHAR(25) NOT NULL,
  description TEXT,
  initial_date DATE NOT NULL,
  end_date DATE,
  user_uuid CHAR(36) NOT NULL,
  PRIMARY KEY (id)
);


-- TRAIN
CREATE TABLE trains(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  user_uuid CHAR(36) NOT NULL,
  week_day TINYINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  created_at DATE DEFAULT(CURRENT_DATE),
  updated_at DATE DEFAULT(CURRENT_DATE),  
  is_visible BIT DEFAULT 1,
  PRIMARY KEY (id)
);

CREATE TABLE exercises(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  image_url VARCHAR(255) NOT NULL,
  video_url VARCHAR(255),
  category VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE trains_exercises(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  exercise_id BIGINT UNSIGNED NOT NULL,
  train_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (exercise_id) REFERENCES exercises(id),
  FOREIGN KEY (train_id) REFERENCES trains(id)
);

CREATE TABLE sets(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  exercise_id BIGINT UNSIGNED NOT NULL,
  train_id BIGINT UNSIGNED NOT NULL,
  weight SMALLINT,
  reps TINYINT,
  minutes SMALLINT,
  PRIMARY KEY (id),
  FOREIGN KEY (exercise_id) REFERENCES exercises(id),
  FOREIGN KEY (train_id) REFERENCES trains(id)
);


-- EXERCISES
CREATE TABLE exercises_muscles(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  muscle VARCHAR(25) NOT NULL,
  exercise_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

CREATE TABLE equipments(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  image_url VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE exercises_equipments(
  exercise_id BIGINT UNSIGNED NOT NULL,
  equipment_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (exercise_id, equipment_id),
  FOREIGN KEY (exercise_id) REFERENCES exercises(id),
  FOREIGN KEY (equipment_id) REFERENCES equipments(id)
);


-- TRAINS LOG
CREATE TABLE trains_logs(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  user_uuid CHAR(36) NOT NULL,
  train_id BIGINT UNSIGNED NOT NULL,
  date DATE DEFAULT(CURRENT_DATE),
  time_spent SMALLINT,
  PRIMARY KEY (id),
  FOREIGN KEY (train_id) REFERENCES trains(id)
);

CREATE TABLE exercises_logs(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  uuid CHAR(36) NOT NULL UNIQUE,
  train_log_id BIGINT UNSIGNED NOT NULL,
  exercise_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (train_log_id) REFERENCES trains_logs(id),
  FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

CREATE TABLE sets_logs(
  id BIGINT UNSIGNED AUTO_INCREMENT,
  exercise_log_id BIGINT UNSIGNED NOT NULL,
  set_id BIGINT UNSIGNED NOT NULL,
  weight SMALLINT,
  reps TINYINT,
  minutes SMALLINT,
  PRIMARY KEY (id),
  FOREIGN KEY (exercise_log_id) REFERENCES exercises_logs(id),
  FOREIGN KEY (set_id) REFERENCES sets(id)
);