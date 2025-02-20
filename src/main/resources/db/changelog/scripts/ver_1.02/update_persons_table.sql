-- liquibase formatted sql
-- changeset persons:2


ALTER TABLE `springboot`.`persons`
    ADD COLUMN `team_id` INT(11) NULL DEFAULT NULL AFTER `password`,
ADD INDEX `fk_persons_team1_idx` (`team_id` ASC) VISIBLE,
ADD UNIQUE INDEX `team_id_UNIQUE` (`team_id` ASC) VISIBLE;
;


ALTER TABLE `springboot`.`persons`
    ADD CONSTRAINT `fk_persons_team1`
        FOREIGN KEY (`team_id`)
            REFERENCES `springboot`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

-- liquibase formatted sql
-- changeset team:4

ALTER TABLE `springboot`.`team`
    ADD COLUMN `persons_id` INT(11) NULL DEFAULT NULL AFTER `wiki_url`,
ADD INDEX `fk_team_persons1_idx` (`persons_id` ASC) VISIBLE,
ADD UNIQUE INDEX `persons_id_UNIQUE` (`persons_id` ASC) VISIBLE;
;

ALTER TABLE `springboot`.`team`
    ADD CONSTRAINT `fk_team_persons1`
        FOREIGN KEY (`persons_id`)
            REFERENCES `springboot`.`persons` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;