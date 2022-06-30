CREATE TABLE app_user
(
    id       SERIAL PRIMARY KEY,
    email    VARCHAR(60) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL
);

CREATE TABLE authority
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE app_user_has_authority
(
    user_id      INTEGER REFERENCES app_user (id),
    authority_id INTEGER REFERENCES authority (id),
    PRIMARY KEY (user_id, authority_id)
);
