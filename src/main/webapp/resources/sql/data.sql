-- ROLES
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- ANIMAL TYPES
INSERT INTO types (name) VALUES ('Pies');
INSERT INTO types (name) VALUES ('Kot');
INSERT INTO types (name) VALUES ('Królik');
INSERT INTO types (name) VALUES ('Wąż');
INSERT INTO types (name) VALUES ('Chomik');
INSERT INTO types (name) VALUES ('Szynszyl');

-- ANIMAL BREEDS

-- dogs
INSERT INTO breeds (name, type_id) VALUES ('Owczarek', 1);
INSERT INTO breeds (name, type_id) VALUES ('Buldog francuski', 1);
INSERT INTO breeds (name, type_id) VALUES ('Dog niemiecki', 1);
INSERT INTO breeds (name, type_id) VALUES ('Dobermann', 1);
INSERT INTO breeds (name, type_id) VALUES ('York', 1);

-- cats
INSERT INTO breeds (name, type_id) VALUES ('Perski', 2);
INSERT INTO breeds (name, type_id) VALUES ('Syjamski', 2);
INSERT INTO breeds (name, type_id) VALUES ('Brytyjski krótkowłosy', 2);
INSERT INTO breeds (name, type_id) VALUES ('Bengalski', 2);
INSERT INTO breeds (name, type_id) VALUES ('Rosyjski niebieski', 2);