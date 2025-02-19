-- liquibase formatted sql
-- changeset persons:1

INSERT INTO persons (username, password)
VALUES ('Anton', '$2a$10$zI6qE7OaNk2Yr33hSzZoLeVm8eV3gVJLsMT8j2.O1HjW0J9AKx2zq'),  -- 11111
       ('Andrey', '$2a$10$YZF1GuJNYtuT1U0PLPa1HeaH2Y2WOSU4q.BGdLsOV3AmwMtclIS/u'), -- 22222
       ('vafler', '$2a$10$YjY1ZODZ2MJW.Tpu/Srf6e8YVHZV7H1PdhzrrpIrwvdP1WBk9vW2S'); -- 33333