CREATE TABLE users_full (
  id INT AUTO_INCREMENT,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  basic_id INT UNIQUE NOT NULL,
  description TINYTEXT,
  birth DATE NOT NULL,
  backdrop_url VARCHAR(255),
  gender CHAR(1) NOT NULL CHECK (gender IN ("M", "F", "N")),
  height SMALLINT NOT NULL,
  full_name TEXT,
  work_as VARCHAR(100),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE settings (
  id INT AUTO_INCREMENT,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  user_id INT UNIQUE NOT NULL,
  theme TINYINT,
  two_factor_auth TINYINT,
  notifications TINYINT,
  email_notifications TINYINT,
  PRIMARY KEY (id)
);

CREATE TABLE users_basic (
  id INT AUTO_INCREMENT,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  full_id INT UNIQUE NOT NULL,
  settings_id INT UNIQUE NOT NULL,
  username VARCHAR(50) UNIQUE NOT NULL,
  avatar_url VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password TEXT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (full_id) REFERENCES users_full(id),
  FOREIGN KEY (settings_id) REFERENCES settings(id)
);

ALTER TABLE users_full
ADD FOREIGN KEY (basic_id) REFERENCES users_basic(id);

ALTER TABLE settings
ADD FOREIGN KEY (user_id) REFERENCES users_basic(id);
