-- Run in MySQL first
DROP DATABASE IF EXISTS DataJdbcWorkshop;
CREATE DATABASE DataJdbcWorkshop;
USE DataJdbcWorkshop;

CREATE TABLE Course(
  id int AUTO_INCREMENT NOT NULL,
  code varchar(50) NOT NULL,
  name varchar(250) NOT NULL,
  description varchar(300) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO Course(Id, Code, Name, Description)
VALUES (1, 'FOPCS', 'Foundations of Programming with C#', 'Write programs using C# with Visual Studio'),
    (2, 'OOPCS', 'Object Oriented with C#', 'Understand and program on main Object Oriented concepts'),
    (3, 'MVC.NET', 'ASP.NET MVC Programming', 'Understand and develop web applications using ASP.NET MVC');


CREATE TABLE Lecturer(
  id int AUTO_INCREMENT NOT NULL,
  username varchar(50) NOT NULL,
  firstName varchar(50) NOT NULL,
  lastName varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO Lecturer(id, username, firstName, lastName) 
VALUES (1, 'isstcw', 'Cher Wah', 'Tan'),
    (2, 'issntt', 'Tri Tin', 'Nguyen'),
    (3, 'isslf', 'Fan', 'Liu');

CREATE TABLE LecturerCourse(
  lecturerId int NOT NULL,
  courseId int NOT NULL,
  PRIMARY KEY(lecturerId, courseId)
);

INSERT INTO LecturerCourse(LecturerId, CourseId)
  VALUES (1,2), (1,3), (2,2), (2,3), (3,2);