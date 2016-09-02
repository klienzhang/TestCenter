CREATE TABLE `TestCenter`.`tools_mobile_core` (
  `id` INT NOT NULL COMMENT '',
  `mobile` VARCHAR(45) NULL COMMENT '',
  `owner` INT NULL COMMENT '',
  `current_user` VARCHAR(45) NULL COMMENT '',
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `comment` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
  ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE `TestCenter`.`tools_mobile_leader` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `comment` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
  ENGINE = InnoDB DEFAULT CHARSET = utf8;
