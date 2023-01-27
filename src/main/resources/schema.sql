DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS instruments;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS user_instruments;
DROP TABLE IF EXISTS user_genres;

CREATE TABLE users (
  user_id INT(15) NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) NOT NULL UNIQUE,
  salted_pass VARCHAR(256),
  name_first VARCHAR(255) NOT NULL,
  name_last VARCHAR(255) NOT NULL,
  birthdate DATE NOT NULL,
  location_zipcode INT NOT NULL,
  location_city VARCHAR(50) NOT NULL,
  location_state VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id));

CREATE TABLE instruments (
    instrument_id INT(15) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    PRIMARY KEY (instrument_id));

CREATE TABLE genres (
    genre_id INT(15) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (genre_id));

CREATE TABLE user_instruments (
    user_id INT NOT NULL,
    instrument_id INT NOT NULL,
    skill INT NOT NULL,
    PRIMARY KEY (user_id, instrument_id));

CREATE TABLE user_genres (
    user_id INT NOT NULL,
    genre_id INT NOT NULL,
    PRIMARY KEY (user_id, genre_id));
