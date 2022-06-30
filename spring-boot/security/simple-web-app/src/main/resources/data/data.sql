INSERT INTO app_user(email, password)
VALUES ('mike@mike.com', '123'),
       ('user@user.com', '123');

INSERT INTO authority(name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

INSERT INTO app_user_has_authority(user_id, authority_id)
VALUES (1, 1),
       (1, 2),
       (2, 2);