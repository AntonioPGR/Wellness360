ALTER TABLE body_part_goal
ADD user_uuid CHAR(36) NOT NULL;

ALTER TABLE injuries
ADD user_uuid CHAR(36) NOT NULL;

ALTER TABLE sets
ADD category VARCHAR(25) NOT NULL;

ALTER TABLE exercises
MODIFY COLUMN image_url VARCHAR(255) NOT NULL;

ALTER TABLE trains_exercises
DROP COLUMN uuid;

RENAME TABLE `body_part_goal` TO `body_focus`;

RENAME TABLE `set_log` TO `sets_logs`;

RENAME TABLE `trains_log` TO `trains_logs`;

RENAME TABLE `exercises_log` TO `exercises_logs`;