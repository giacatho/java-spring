DROP SCHEMA IF EXISTS cats;

CREATE SCHEMA cats;

USE cats;

CREATE TABLE employee (
  employeeid VARCHAR(15) NOT NULL,
  managerid VARCHAR(15) NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (employeeid)
);


CREATE TABLE role (
  roleid VARCHAR(15) NOT NULL,
  name VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  PRIMARY KEY (roleid));


CREATE TABLE user (
  userid VARCHAR(15) NOT NULL,
  name VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  employeeid VARCHAR(15) NULL,
  PRIMARY KEY (userid),
  INDEX efk_idx (employeeid ASC),
  CONSTRAINT efk
    FOREIGN KEY (employeeid)
    REFERENCES employee (employeeid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE userrole (
  roleid VARCHAR(15) NOT NULL,
  userid VARCHAR(15) NOT NULL,
  PRIMARY KEY (roleid, userid),
  CONSTRAINT ufk
    FOREIGN KEY (userid)
    REFERENCES user (userid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT rfk
    FOREIGN KEY (roleid)
    REFERENCES role (roleid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE department (
  departmentid VARCHAR(15) NOT NULL,
  managerid VARCHAR(15) NOT NULL,
  PRIMARY KEY (departmentid),
  INDEX mfk_idx (managerid ASC),
  CONSTRAINT mfk
    FOREIGN KEY (managerid)
    REFERENCES employee (employeeid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE course (
  courseid int NOT NULL AUTO_INCREMENT,
  employeeid VARCHAR(15) NULL,
  coursename VARCHAR(45) NULL,
  organiser VARCHAR(45) NULL,
  fromdate DATE NULL,
  todate DATE NULL,
  fees DOUBLE NULL,
  gstincluded boolean NULL,
  justification VARCHAR(100) NULL,
  status enum('SUBMITTED', 'APPROVED', 'WITHDRAWN', 'UPDATED', 'REJECTED') NOT NULL,
  comments VARCHAR(100) NULL, PRIMARY KEY (courseid),
  INDEX efk_idx (employeeid ASC),
  CONSTRAINT efk1
    FOREIGN KEY (employeeid)
    REFERENCES employee (employeeid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE courseevent (
  courseeventid int NOT NULL AUTO_INCREMENT,
  courseid int NULL,
  timestamp DATE NULL,
  eventtype VARCHAR(20) NULL,
  eventby VARCHAR(30) NULL,
  comment VARCHAR(100) NULL,
  PRIMARY KEY (courseeventid),
  INDEX cfk_idx (courseid ASC),
  CONSTRAINT cfk
    FOREIGN KEY (courseid)
    REFERENCES course (courseid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

--   
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('dilbert', 'pointy', 'Dilbert');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('pointy', 'dogbert', 'Pointy');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('alice', 'pointy', 'Alice');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('wally', 'pointy', 'Wally');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('ashok', 'dilbert', 'Ashok');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('dogbert', '', 'Dogbert');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('ted', '', 'Ted');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('howard', '', 'Loud Howard');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('catbert', 'dogbert', 'Catbert HR');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('ratbert', 'dogbert', 'Ratbert low form');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('bob', 'pointy', 'Bob the dino');
INSERT INTO employee (employeeid, managerid, name)
            VALUES ('tina', '', 'Tina the technical writer');

--
INSERT INTO role (roleid, name, description)
            VALUES ('admin', 'Administrator', 'System administrator');
INSERT INTO role (roleid, name, description)
            VALUES ('staff', 'Staff', 'Staff members');
INSERT INTO role (roleid, name, description)
            VALUES ('manager', 'Manager', 'Manager');

--
INSERT INTO user(userid,name,password,employeeid)
      VALUES('dilbert','dilbert','dilbert','dilbert');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('pointy','pointy','pointy','pointy');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('alice','alice','alice','alice');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('wally','wally','wally','wally');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('ashok','ashok','ashok','ashok');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('dogbert','dogbert','dogbert','dogbert');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('ted','ted','ted','ted');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('howard','howard','howard','howard');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('catbert','catbert','catbert','catbert');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('ratbert','ratbert','ratbert','ratbert');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('bob','bob','bob','bob');
INSERT INTO user(userid,name,password,employeeid)
      VALUES('tina','tina','tina','tina');

--
INSERT INTO userrole(roleid,userid)
        VALUES('manager','dilbert');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','dilbert');
INSERT INTO userrole(roleid,userid)
        VALUES('manager','pointy');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','pointy');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','alice');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','wally');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','ashok');
INSERT INTO userrole(roleid,userid)
        VALUES('manager','dogbert');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','dogbert');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','ted');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','howard');
INSERT INTO userrole(roleid,userid)
        VALUES('admin','catbert');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','catbert');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','ratbert');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','bob');
INSERT INTO userrole(roleid,userid)
        VALUES('staff','tina');
--

INSERT INTO department(departmentid,managerid)
          VALUES('engineering','pointy');
INSERT INTO department(departmentid,managerid)
          VALUES('hr','catbert');



