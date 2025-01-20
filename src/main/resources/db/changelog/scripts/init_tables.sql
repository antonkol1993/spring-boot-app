-- liquibase formatted sql
-- changeset anton:1

-- Schema springboot
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springboot` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema springboot
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springboot
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springboot` DEFAULT CHARACTER SET utf8 ;
USE `springboot` ;

-- -----------------------------------------------------
-- Table `springboot`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`team` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `country` VARCHAR(45) NULL,
    `city` VARCHAR(45) NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springboot`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`game` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `home_team_id` INT NULL,
    `away_team_id` INT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_game_team1_idx` (`home_team_id` ASC) VISIBLE,
    INDEX `fk_game_team2_idx` (`away_team_id` ASC) VISIBLE,
    CONSTRAINT `fk_game_team1`
    FOREIGN KEY (`home_team_id`)
    REFERENCES `springboot`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_game_team2`
    FOREIGN KEY (`away_team_id`)
    REFERENCES `springboot`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springboot`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`player` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `age` INT NULL,
    `country` VARCHAR(45) NULL,
    `position` VARCHAR(45) NULL,
    `rating` VARCHAR(45) NULL,
    `team_id` INT NULL,
    `game_id` INT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_player_team1_idx` (`team_id` ASC) VISIBLE,
    INDEX `fk_player_game1_idx` (`game_id` ASC) VISIBLE,
    CONSTRAINT `fk_player_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `springboot`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_player_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `springboot`.`game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `springboot`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`person` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) NULL,
    `last_name` VARCHAR(45) NULL,
    `age` INT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


--changeset anton:2

ALTER TABLE `springboot`.`player`
DROP COLUMN `position`,
DROP COLUMN `country`,
ADD COLUMN `country_id` INT(11) NULL DEFAULT NULL AFTER `game_id`,
ADD COLUMN `position_id` INT(11) NULL DEFAULT NULL AFTER `country_id`,
ADD INDEX `fk_player_country1_idx` (`country_id` ASC) VISIBLE,
ADD INDEX `fk_player_position1_idx` (`position_id` ASC) VISIBLE;
;

CREATE TABLE IF NOT EXISTS `springboot`.`country` (
                                                      `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    `capital_city` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `springboot`.`position` (
                                                       `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci
    COMMENT = '			';

ALTER TABLE `springboot`.`player`
    ADD CONSTRAINT `fk_player_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_player_position1`
  FOREIGN KEY (`position_id`)
  REFERENCES `springboot`.`position` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset anton:3

ALTER TABLE `springboot`.`player`
DROP FOREIGN KEY `fk_player_country1`,
DROP FOREIGN KEY `fk_player_position1`;

ALTER TABLE `springboot`.`team`
    ADD COLUMN `country_id` INT(11) NOT NULL AFTER `city`,
ADD INDEX `fk_team_country1_idx` (`country_id` ASC) VISIBLE;
;

ALTER TABLE `springboot`.`player`
    ADD CONSTRAINT `fk_player_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_player_position1`
  FOREIGN KEY (`position_id`)
  REFERENCES `springboot`.`position` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `springboot`.`team`
    ADD CONSTRAINT `fk_team_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

--changeset anton:4

ALTER TABLE `springboot`.`game`
DROP FOREIGN KEY `fk_game_team1`,
DROP FOREIGN KEY `fk_game_team2`;

ALTER TABLE `springboot`.`player`
DROP FOREIGN KEY `fk_player_country1`,
DROP FOREIGN KEY `fk_player_position1`;

ALTER TABLE `springboot`.`team`
DROP FOREIGN KEY `fk_team_country1`;

ALTER TABLE `springboot`.`game`
DROP COLUMN `away_team_id`,
DROP COLUMN `home_team_id`,
ADD COLUMN `away_team` INT(11) NOT NULL AFTER `name`,
ADD COLUMN `home_team` INT(11) NOT NULL AFTER `away_team`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`, `away_team`, `home_team`),
ADD INDEX `fk_game_team1_idx` (`away_team` ASC) VISIBLE,
ADD INDEX `fk_game_team2_idx` (`home_team` ASC) VISIBLE,
DROP INDEX `fk_game_team2_idx` ,
DROP INDEX `fk_game_team1_idx` ;
;

ALTER TABLE `springboot`.`team`
    ADD INDEX `fk_team_country1_idx` (`country_id` ASC) VISIBLE,
DROP INDEX `fk_team_country1_idx` ;
;

ALTER TABLE `springboot`.`game`
    ADD CONSTRAINT `fk_game_team1`
        FOREIGN KEY (`away_team`)
            REFERENCES `springboot`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_game_team2`
  FOREIGN KEY (`home_team`)
  REFERENCES `springboot`.`team` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `springboot`.`player`
    ADD CONSTRAINT `fk_player_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_player_position1`
  FOREIGN KEY (`position_id`)
  REFERENCES `springboot`.`position` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `springboot`.`team`
    ADD CONSTRAINT `fk_team_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;



--changeset anton:5

ALTER TABLE `springboot`.`game`
DROP FOREIGN KEY `fk_game_team1`,
DROP FOREIGN KEY `fk_game_team2`;

ALTER TABLE `springboot`.`player`
DROP FOREIGN KEY `fk_player_country1`,
DROP FOREIGN KEY `fk_player_position1`;

ALTER TABLE `springboot`.`team`
DROP FOREIGN KEY `fk_team_country1`;

ALTER TABLE `springboot`.`game`
DROP COLUMN `home_team`,
DROP COLUMN `away_team`,
ADD COLUMN `team_id` INT(11) NOT NULL AFTER `name`,
ADD COLUMN `team_id1` INT(11) NOT NULL AFTER `team_id`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`),
ADD INDEX `fk_game_team1_idx` (`team_id` ASC) VISIBLE,
ADD INDEX `fk_game_team2_idx` (`team_id1` ASC) VISIBLE,
DROP INDEX `fk_game_team2_idx` ,
DROP INDEX `fk_game_team1_idx` ;
;

ALTER TABLE `springboot`.`team`
    ADD COLUMN `game_id` INT(11) NOT NULL AFTER `country_id`,
ADD INDEX `fk_team_country1_idx` (`country_id` ASC) VISIBLE,
ADD INDEX `fk_team_game1_idx` (`game_id` ASC) VISIBLE,
DROP INDEX `fk_team_country1_idx` ;
;

ALTER TABLE `springboot`.`game`
    ADD CONSTRAINT `fk_game_team1`
        FOREIGN KEY (`team_id`)
            REFERENCES `springboot`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_game_team2`
  FOREIGN KEY (`team_id1`)
  REFERENCES `springboot`.`team` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `springboot`.`player`
    ADD CONSTRAINT `fk_player_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_player_position1`
  FOREIGN KEY (`position_id`)
  REFERENCES `springboot`.`position` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `springboot`.`team`
    ADD CONSTRAINT `fk_team_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_team_game1`
  FOREIGN KEY (`game_id`)
  REFERENCES `springboot`.`game` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--changeset anton:6

ALTER TABLE `springboot`.`game`
DROP FOREIGN KEY `fk_game_team1`;

ALTER TABLE `springboot`.`player`
DROP FOREIGN KEY `fk_player_country1`,
DROP FOREIGN KEY `fk_player_position1`;

ALTER TABLE `springboot`.`team`
DROP FOREIGN KEY `fk_team_country1`,
DROP FOREIGN KEY `fk_team_game1`;

ALTER TABLE `springboot`.`game`
    CHANGE COLUMN `team_id1` `team_id1` INT(11) NULL DEFAULT NULL AFTER `name`,
    CHANGE COLUMN `team_id` `team_id` INT(11) NULL DEFAULT NULL ,
    ADD INDEX `fk_game_team2_idx` (`team_id1` ASC) VISIBLE,
    ADD INDEX `fk_game_team1_idx` (`team_id` ASC) VISIBLE,
DROP INDEX `fk_game_team2_idx` ,
DROP INDEX `fk_game_team1_idx` ;
;

ALTER TABLE `springboot`.`team`
    CHANGE COLUMN `country_id` `country_id` INT(11) NULL DEFAULT NULL ,
    CHANGE COLUMN `game_id` `game_id` INT(11) NULL DEFAULT NULL ,
    ADD INDEX `fk_team_country1_idx` (`country_id` ASC) VISIBLE,
    ADD INDEX `fk_team_game1_idx` (`game_id` ASC) VISIBLE,
DROP INDEX `fk_team_game1_idx` ,
DROP INDEX `fk_team_country1_idx` ;
;

ALTER TABLE `springboot`.`game`
DROP FOREIGN KEY `fk_game_team2`;

ALTER TABLE `springboot`.`game` ADD CONSTRAINT `fk_game_team2`
    FOREIGN KEY (`team_id1`)
        REFERENCES `springboot`.`team` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_game_team1`
  FOREIGN KEY (`team_id`)
  REFERENCES `springboot`.`team` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `springboot`.`player`
    ADD CONSTRAINT `fk_player_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_player_position1`
  FOREIGN KEY (`position_id`)
  REFERENCES `springboot`.`position` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `springboot`.`team`
    ADD CONSTRAINT `fk_team_country1`
        FOREIGN KEY (`country_id`)
            REFERENCES `springboot`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_team_game1`
  FOREIGN KEY (`game_id`)
  REFERENCES `springboot`.`game` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
