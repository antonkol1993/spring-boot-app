-- liquibase formatted sql
-- changeset persons:1

INSERT INTO persons (username, password)
VALUES ('Anton', '$2a$10$CKAsd2wafUJj6HgMub2/desdg3T01WzZKSfn1H/W9CwJAXtIwCMYa'),  -- 11111
       ('Andrey', '$2a$10$sGW7lF.F8Vu5zF6A96sUEO4ulZBTfIJlLyPAur8fBIAfJ6Sp9ybn.'), -- 22222
       ('vafler', '$2a$10$9QJumY.bP5jFfdWIVLq5NeGuChytkAJXUBJOUQgGsgRRgkRXhq3Ba'), -- 33333
       ('a', '$2a$10$VrxkgvVPhCo3GkNJqHCoRu6EDdHYUU2vcQSLHuLeBIamrJD38fwti'); -- a