CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(50),
    password   VARCHAR(50),
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    zip        VARCHAR(50)
);

CREATE TABLE orders
(
    id           SERIAL PRIMARY KEY,
    user_id      INT REFERENCES users (id),
    product_name VARCHAR(100)
);