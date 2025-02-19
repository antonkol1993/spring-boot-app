-- liquibase formatted sql
-- changeset role:1
insert into roles (name)
values ('USER'),
       ('ADMIN'),
       ('MANAGER');