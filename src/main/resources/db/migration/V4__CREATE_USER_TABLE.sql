CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (name, email, password) VALUES ('Neymar', 'menino.ney@gmail.com', '$2a$12$shAdjRaRcBi4oRMYOfpcmuB14yAAfZywwoT3.20SuJPHC645ee5AK'); --password123
INSERT INTO users (name, email, password) VALUES ('Adriano Imperador', 'imperador@gmail.com', '$2a$12$BoD9D0w2hkUvwfpSL2jVQ.pU5TIv1Wu1olQVKDcXOctBHtUawMABq'); --password456
