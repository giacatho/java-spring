-- For clean start, drop database if it exists 
DROP DATABASE IF EXISTS jpa_getstarted_workshop;

-- Create database jpa-getstarted-workshop 
CREATE DATABASE jpa_getstarted_workshop;

-- Use database jpa-getstarted-workshop 
USE jpa_getstarted_workshop;

-- Create table Course 
CREATE TABLE Course(
	Code varchar(50) NOT NULL,
	Name varchar(250) NOT NULL,
	PRIMARY KEY (Code)
);

-- Insert data into table Course 
INSERT INTO Course(Code, Name)
VALUES ('FOP', 'Fundamentals of Programming'),
		('OOP', 'Object Oriented Programming'),
		('SQL', 'Database Programming with SQL');

