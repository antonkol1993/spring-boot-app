-- liquibase formatted sql
-- changeset antonio:1
insert into player (age, id, name, position)
values  (30, 1, 'messi', 'forward'),
        (null, 2, 'Maradonna', null),
        (35, 3, 'Antonio', 'forward'),
        (35, 4, 'Henry', 'forward'),
        (null, 5, 'Lahm', 'defender');