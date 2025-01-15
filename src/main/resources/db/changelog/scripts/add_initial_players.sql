-- liquibase formatted sql
-- changeset antonio:1
insert into player (age, name, position)
values (30, 'messi', 'forward'),
       (59, 'Maradonna', null),
       (35, 'Antonio', 'forward'),
       (35, 'Henry', 'forward'),
       (null, 'Leonardo', 'defender'),
       (null, 'Jamal', 'defender'),
       (null, 'Rafinha', 'defender'),
       (null, 'Vinchenso', 'defender'),
       (null, 'Lewandovsky', 'defender');