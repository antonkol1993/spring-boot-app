-- liquibase formatted sql
-- changeset antonio:1
create table player
(
    age      int          null,
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
-- changeset anton:4
create table team
(
    id      int auto_increment
        primary key,
    name    varchar(255) null,
    country varchar(255) null,
    city    varchar(255) null
);
-- changeset anton:5
alter table player
    modify team varchar(255) null;

-- changeset anton:6
create table game
(
    id   int auto_increment
        primary key,
    name varchar(255) null
);
-- changeset anton:7
create table person
(
    id int auto_increment
        primary key,
    firstName char(255),
    lastName char(255),
    age int
)
