-- liquibase formatted sql
-- changeset player:3

ALTER TABLE `springboot`.`player`
    ADD COLUMN `image_url` TEXT NULL DEFAULT NULL AFTER `position_id`,
ADD COLUMN `wiki_url` TEXT NULL DEFAULT NULL AFTER `image_url`;