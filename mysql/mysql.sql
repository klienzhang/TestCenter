CREATE TABLE `TestCenter`.`component_sliderbar_main_menu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `main_name` VARCHAR(45) NULL,
  `parent_code` INT(11) NULL Unique,
  `create_time` DATETIME DEFAULT current_timestamp,
  `creater` INT(11) default 1,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT(11) default 1,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `TestCenter`.`component_sliderbar_sub_menu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sub_name` VARCHAR(45) NULL,
  `parent_code` INT(11) NULL,
  `create_time` DATETIME DEFAULT current_timestamp,
  `creater` INT(11) default 1,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT(11) default 1,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#####################################################
CREATE TABLE `TestCenter`.`quicklink_menu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `url` VARCHAR (255) NULL ,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT(11) default 1,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;
#####################################################

#####################################################
CREATE TABLE `TestCenter`.`project_progress` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` INT(11) NULL,
  `name` VARCHAR (255) NULL ,
  `progress` INT(11) NULL,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT(11) default 1,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;
#####################################################

CREATE TABLE `TestCenter`.`berserker_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `create_time` DATETIME DEFAULT current_timestamp,
  `creater` INT(11) default 1,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT(11) default 1,
  `authority` INT(11) default 1,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#####################################################
CREATE TABLE `TestCenter`.`berserker_notice` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `icon` INT(11) NULL,
  `title` VARCHAR(45) NULL,
  `content` longtext NULL,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT(11) default 1,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;
#####################################################

ALTER TABLE `TestCenter`.`component_sliderbar_sub_menu`
ADD COLUMN `url` VARCHAR(255) NULL AFTER `updater`;

CREATE TABLE `TestCenter`.`tools_agent_search_prefix_config` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `prefix_url` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

/*********************************************************************************/
/*                         账号管理工具SQL                                         */
/*********************************************************************************/
CREATE TABLE `TestCenter`.`tools_agent_department`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `isHeadQuarter` INT,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT DEFAULT 1,
  PRIMARY KEY (`id`)
)engine=InnoDB Default CHARSET = utf8;

CREATE TABLE `TestCenter`.`tools_agent_city`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NULL,
  `update_time` DATETIME DEFAULT current_timestamp,
  `updater` INT DEFAULT 1,
  PRIMARY KEY (`id`)
)engine=InnoDB Default CHARSET = utf8;

CREATE TABLE `TestCenter`.`tools_agent_position`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `department_code` INT,
  `name` VARCHAR(255),
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

/*********************************************************************************/
/*                            手机管理SQL                                         */
/*********************************************************************************/
CREATE TABLE `TestCenter`.`test_mobile_management`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`mobile` VARCHAR(45) NULL,
	`serial_code` VARCHAR(45) NULL,
	`owner_group` INT,
	`current_user` VARCHAR(255),
	`update_time` DATETIME DEFAULT current_timestamp,
	`updater` INT DEFAULT 1,
	PRIMARY KEY (`id`)
)engine=InnoDB Default CHARSET = utf8;
/*********************************************************************************/

