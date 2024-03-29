DROP TABLE IF EXISTS books;

CREATE TABLE books(
id INT AUTO_INCREMENT PRIMARY KEY,
author VARCHAR(250) NOT NULL,
title VARCHAR(250) NOT NULL,
priceOld  VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS genres;

CREATE TABLE genres(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS genres;

CREATE TABLE authors(
id INT,
last_name VARCHAR(250),
first_name VARCHAR(250)
);