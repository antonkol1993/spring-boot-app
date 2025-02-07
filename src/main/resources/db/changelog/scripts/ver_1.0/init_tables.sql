-- liquibase formatted sql
-- changeset create tables:1

-- Schema springboot
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springboot` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `springboot` ;

-- -----------------------------------------------------
-- Table `springboot`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`country` (
                                                      `id` INT NOT NULL AUTO_INCREMENT,
                                                      `name` VARCHAR(45) NULL DEFAULT NULL,
    `capital_city` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 11
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `springboot`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`team` (
                                                   `id` INT NOT NULL AUTO_INCREMENT,
                                                   `name` VARCHAR(45) NULL DEFAULT NULL,
    `country` VARCHAR(45) NULL DEFAULT NULL,
    `city` VARCHAR(45) NULL DEFAULT NULL,
    `country_id` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_team_country1_idx` (`country_id` ASC) VISIBLE,
    CONSTRAINT `fk_team_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `springboot`.`country` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 12
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `springboot`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`game` (
                                                   `id` INT NOT NULL AUTO_INCREMENT,
                                                   `name` VARCHAR(45) NULL DEFAULT NULL,
    `home_team` INT NULL,
    `away_team` INT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_game_team1_idx` (`home_team` ASC) VISIBLE,
    INDEX `fk_game_team2_idx` (`away_team` ASC) VISIBLE,
    CONSTRAINT `fk_game_team1`
    FOREIGN KEY (`home_team`)
    REFERENCES `springboot`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_game_team2`
    FOREIGN KEY (`away_team`)
    REFERENCES `springboot`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    AUTO_INCREMENT = 6
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `springboot`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`person` (
                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                     `first_name` VARCHAR(45) NULL DEFAULT NULL,
    `last_name` VARCHAR(45) NULL DEFAULT NULL,
    `age` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 12
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `springboot`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`position` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `name` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci
    COMMENT = '			';


-- -----------------------------------------------------
-- Table `springboot`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`player` (
                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(45) NULL DEFAULT NULL,
    `age` INT NULL DEFAULT NULL,
    `rating` VARCHAR(45) NULL DEFAULT NULL,
    `team_id` INT NULL DEFAULT NULL,
    `game_id` INT NULL DEFAULT NULL,
    `country_id` INT NULL DEFAULT NULL,
    `position_id` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_player_team1_idx` (`team_id` ASC) VISIBLE,
    INDEX `fk_player_game1_idx` (`game_id` ASC) VISIBLE,
    INDEX `fk_player_country1_idx` (`country_id` ASC) VISIBLE,
    INDEX `fk_player_position1_idx` (`position_id` ASC) VISIBLE,
    CONSTRAINT `fk_player_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `springboot`.`country` (`id`),
    CONSTRAINT `fk_player_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `springboot`.`game` (`id`),
    CONSTRAINT `fk_player_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `springboot`.`position` (`id`),
    CONSTRAINT `fk_player_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `springboot`.`team` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 14
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

-- changeset update table 'Team':2
-- -----------------------------------------------------
-- Table `springboot`.`team`   ( Delete column country )
-- -----------------------------------------------------
ALTER TABLE `springboot`.`team`
DROP COLUMN `country`;

-- changeset add to table 'Team' column:3
ALTER TABLE `springboot`.`team`
    ADD COLUMN `logo_url` VARCHAR(225) NULL DEFAULT NULL AFTER `country_id`;