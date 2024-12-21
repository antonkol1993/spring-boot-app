-- liquibase formatted sql
-- changeset antonio:1
create table player
(
    age      int null,
    id       int auto_increment
        primary key,
    country  varchar(255) null,
    name     varchar(255) null,
    position varchar(255) null,
    rating   varchar(255) null
);

-- changeset antonio:2
alter table player
    add team varchar(255) null;

-- changeset antonio:3
alter table player
    modify team int null;

