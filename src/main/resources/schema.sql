DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Instrument;
DROP TABLE IF EXISTS Genre;
DROP TABLE IF EXISTS User_Instrument;
DROP TABLE IF EXISTS User_Genre;

CREATE TABLE User (
  user_id BIGINT NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) NOT NULL,
  salted_pass VARCHAR(256),
  name_first VARCHAR(255) NOT NULL,
  name_last VARCHAR(255) NOT NULL,
  birthdate DATE NOT NULL,
  location_zipcode INT NOT NULL,
  location_city VARCHAR(50) NOT NULL,
  location_state VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id));

CREATE TABLE Instrument (
    instrument_id INT(15) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    PRIMARY KEY (instrument_id));

CREATE TABLE Genre (
    genre_id INT(15) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (genre_id));

CREATE TABLE User_Instrument (
    user_id INT NOT NULL,
    instrument_id INT NOT NULL,
    skill INT NOT NULL,
    PRIMARY KEY (user_id, instrument_id));

CREATE TABLE User_Genre (
    user_id INT NOT NULL,
    genre_id INT NOT NULL,
    PRIMARY KEY (user_id, genre_id));
