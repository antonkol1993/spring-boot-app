-- liquibase formatted sql
-- changeset role:1
insert into role (name)
values ('USER'),
       ('ADMIN'),
       ('MANAGER');