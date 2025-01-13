-- liquibase formatted sql
-- changeset antonio:1
insert into player (age, id, name, position)
values (30, 1, 'messi', 'forward'),
       (59, 2, 'Maradonna', null),
       (35, 3, 'Antonio', 'forward'),
       (35, 4, 'Henry', 'forward'),
       (null, 5, 'Leonardo', 'defender'),
    (null , 6, 'Jamal', 'defender'),
    (null , 7, 'Rafinha', 'defender'),
    (null , 8, 'Vinchenso', 'defender'),
    (null , 9, 'Lewandovsky', 'defender');