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
