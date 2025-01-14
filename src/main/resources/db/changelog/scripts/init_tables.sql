-- liquibase formatted sql
-- changeset anton:1

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
-- Table `springboot`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`player` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR(45) NULL,
    `age` INT NULL,
    `country` VARCHAR(45) NULL,
    `position` VARCHAR(45) NULL,
    `rating` VARCHAR(45) NULL,
    `team_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_player_team1_idx` (`team_id` ASC) VISIBLE,
    CONSTRAINT `fk_player_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `springboot`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springboot`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot`.`game` (
                                             `id` INT NOT NULL AUTO_INCREMENT,
                                             `name` VARCHAR(45) NULL,
    `team_id` INT NOT NULL,
    `team_id1` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_game_team_idx` (`team_id` ASC) VISIBLE,
    INDEX `fk_game_team1_idx` (`team_id1` ASC) VISIBLE,
    CONSTRAINT `fk_game_team`
    FOREIGN KEY (`team_id`)
    REFERENCES `springboot`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_game_team1`
    FOREIGN KEY (`team_id1`)
    REFERENCES `springboot`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;
