-- liquibase formatted sql
-- changeset person_roles:1
insert into person_roles (person_id,role_id)
values (1,2),
       (2,3),
       (3,1);

