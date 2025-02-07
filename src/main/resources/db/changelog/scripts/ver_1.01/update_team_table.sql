-- liquibase formatted sql
-- changeset team:2

ALTER TABLE `springboot`.`team`
    ADD COLUMN `wiki_url` TEXT NULL DEFAULT NULL AFTER `logo_url`,
CHANGE COLUMN `logo_url` `logo_url` TEXT NULL DEFAULT NULL ;

