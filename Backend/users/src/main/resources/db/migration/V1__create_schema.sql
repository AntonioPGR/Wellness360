CREATE TABLE users_basic (
  id INT UNIQUE NOT NULL AUTO_INCREMENT,
  uuid VARCHAR(36) UNIQUE NOT NULL,
  username VARCHAR(50) UNIQUE NOT NULL,
  avatar_url VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  password TEXT NOT NULL,
  role VARCHAR(5) NOT NULL DEFAULT "USER" CHECK (role IN ("USER", "ADMIN")),
  active TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);

CREATE TABLE users_full (
  id INT UNIQUE NOT NULL AUTO_INCREMENT,
  user_id INT UNIQUE NOT NULL,
  description TINYTEXT,
  birth DATE NOT NULL,
  backdrop_url VARCHAR(255),
  gender CHAR(1) NOT NULL CHECK (gender IN ("M", "F", "N")),
  height SMALLINT NOT NULL,
  full_name TEXT,
  work_as VARCHAR(100),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users_basic(id)
);

CREATE TABLE settings (
  id INT UNIQUE NOT NULL AUTO_INCREMENT,
  user_id INT UNIQUE NOT NULL,
  theme TINYINT DEFAULT 0,
  two_factor_auth TINYINT DEFAULT 0,
  notifications TINYINT DEFAULT 1,
  email_notifications TINYINT DEFAULT 1,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users_basic(id)
);