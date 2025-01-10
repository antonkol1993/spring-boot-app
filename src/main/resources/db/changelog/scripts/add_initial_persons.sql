-- liquibase formatted sql
-- changeset antonio:1
insert into person (id, first_name, last_name, age)
values (1,'Anton','Kolesnikov', 31),
       (2,'Andrey','Narut', 33),
       (3,'Vasya','Rostovsky', 12),
       (4,'Petya','Pupkin', 56),
       (5,'Bill','Milligan', 40);