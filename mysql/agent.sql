/*********************************************************************************/
/*                         账号管理工具SQL                                         */
/*********************************************************************************/
CREATE TABLE `TestCenter`.`tools_agent_city`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NULL,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT DEFAULT 1,
  PRIMARY KEY (`id`)
)engine=InnoDB Default CHARSET = utf8;

CREATE TABLE `TestCenter`.`tools_agent_department`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `isHeadQuarter` INT,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT DEFAULT 1,
  PRIMARY KEY (`id`)
)engine=InnoDB Default CHARSET = utf8;

CREATE TABLE `TestCenter`.`tools_agent_position`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255),
  `department_code` INT,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT DEFAULT 1,
  PRIMARY KEY (`id`)
)engine=InnoDB Default CHARSET = utf8;

CREATE TABLE `TestCenter`.`tools_agent_collections`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  `department_code` INT,
  `position_code` INT,
  `city_code` INT,
  `comment` VARCHAR(255),
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT DEFAULT 1,
  PRIMARY KEY (`id`)
)engine=InnoDB Default CHARSET = utf8;
/*********************************************************************************/