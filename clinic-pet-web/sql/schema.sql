--create database
CREATE DATABASE 18_lesson;

--create table
CREATE TABLE client(
  uid serial PRIMARY KEY,
  name VARCHAR(200)
);

CREATE TABLE pet(
  uid serial PRIMARY KEY,
  client_id INT NOT NULL REFERENCES client(uid),
  nick VARCHAR(200)
);

-- add new client
INSERT INTO client (name) VALUES ('Artiom');

--add new pet
INSERT INTO pet (client_id, nick) VALUES (1, 'Sparky');

INSERT INTO pet (client_id, nick) VALUES (1, 'Bobby');

--select all clients
SELECT * FROM client AS client;

--select client by name
SELECT * from client AS client WHERE client.name = 'Artiom';

--select join query
select pet.nick, client.name from pet AS pet INNER JOIN client as client ON client.uid = pet.client_id;

SELECT client.name, pet.nick FROM client AS client INNER JOIN pet as pet ON pet.client_id = client.uid;

--update pet
UPDATE pet as pet SET nick = 'Bob' WHERE nick = 'Bobby';

--delete Pet by nick
DELETE FROM pet WHERE nick = 'Bob';

-- roles
create table roles (
		uid serial primary key,
		name varchar(200)
);

-- users
create table users (
		uid serial primary key,
		login varchar(200),
		email varchar(200),
		role_id int not null references roles(uid)
);

-- messages

-- users
create table messages (
		uid serial primary key,
		text  character varying,
		user_id int not null references users(uid)
);