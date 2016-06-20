--create DB
CREATE DATABASE pet_clinic;

--set pet_clinic
USE pet_clinic;

--create tables clients, pets, pet_type
CREATE TABLE clients(
  client_id VARCHAR (25) PRIMARY KEY,
  name VARCHAR (50),
  email VARCHAR (320),
  phone VARCHAR (15)
);

CREATE TABLE pet_type(
  type_id serial PRIMARY KEY,
  type VARCHAR (30)
);

CREATE TABLE pets(
  id serial PRIMARY KEY,
  name VARCHAR (30),
  type_id INT NOT NULL REFERENCES pet_type(type_id),
  client_id VARCHAR (25) NOT NULL REFERENCES clients(client_id)
);

--insert values into tables
--insert into clients
INSERT INTO clients (client_id, name, email, phone) VALUES ('XX 55555556','Artiom Hotinec', 'artiom-hotinec@rambler.ru', '+963361595');
INSERT INTO clients (client_id, name, email, phone) VALUES ('XX 66789123','Oksana Hotinec', NULL , '+96124789');
INSERT INTO clients (client_id, name, email, phone) VALUES ('XX 77785334','Ivan Ivanov', 'ivan-ivanov@gmail.com', '+956321475');
INSERT INTO clients (client_id, name, email, phone) VALUES ('XX 99156172','Petr Petrov', NULL , '+914452521');
INSERT INTO clients (client_id, name, email, phone) VALUES ('XX 89745123','Daved Bowee', NULL , '+953547898');

--insert into pet_type
INSERT INTO pet_type (type) values ('cat');
INSERT INTO pet_type (type) values ('dog');
INSERT INTO pet_type (type) values ('bird');
INSERT INTO pet_type (type) values ('mouse');

--insert into pets
 INSERT INTO pets (name, type_id, client_id) VALUES ('Bob', 2, 'XX 55555556');
 INSERT INTO pets (name, type_id, client_id) VALUES ('Sparky', 2, 'XX 55555556');
 INSERT INTO pets (name, type_id, client_id) VALUES ('Tuzik', 2, 'XX 55555556');
 INSERT INTO pets (name, type_id, client_id) VALUES ('Kitty', 1, 'XX 55555556');
 INSERT INTO pets (name, type_id, client_id) VALUES ('Popka', 3, 'XX 55555556');

 INSERT INTO pets (name, type_id, client_id) VALUES ('Kiska', 1, 'XX 66789123');
 INSERT INTO pets (name, type_id, client_id) VALUES ('Jack', 2, 'XX 66789123');
 INSERT INTO pets (name, type_id, client_id) VALUES ('Mouse', 1, 'XX 66789123');

 INSERT INTO pets (name, type_id, client_id) VALUES ('Diatel', 3, 'XX 77785334');
 INSERT INTO pets (name, type_id, client_id) VALUES ('Vorobey', 3, 'XX 77785334');

 INSERT into pets (name, type_id, client_id) VALUES ('Tuzik', 2, 'XX 99156172');
 INSERT into pets (name, type_id, client_id) VALUES ('Bob', 2, 'XX 99156172');
 INSERT into pets (name, type_id, client_id) VALUES ('Kitty', 1, 'XX 99156172');
 INSERT into pets (name, type_id, client_id) VALUES ('Murzic', 1, 'XX 99156172');
 INSERT into pets (name, type_id, client_id) VALUES ('Kesha', 3, 'XX 99156172');
 INSERT into pets (name, type_id, client_id) VALUES ('Mouse', 4, 'XX 99156172');

 INSERT INTO pets (name, type_id, client_id) VALUES ('Mops', 2, 'XX 89745123');