-- Run in MySQL first
DROP DATABASE IF EXISTS JdbcTemplateWorkshop;
CREATE DATABASE JdbcTemplateWorkshop;
USE JdbcTemplateWorkshop;

CREATE TABLE Course(
  id int NOT NULL,
  code varchar(50) NOT NULL,
  name varchar(250) NOT NULL,
  description varchar(300) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO Course(Id, Code, Name, Description)
VALUES (1, 'FOPCS', 'Foundations of Programming with C#', 'Write programs using C# with Visual Studio'),
    (2, 'OOPCS', 'Object Oriented with C#', 'Understand and program on main Object Oriented concepts'),
    (3, 'MVC.NET', 'ASP.NET MVC Programming', 'Understand and develop web applications using ASP.NET MVC');
