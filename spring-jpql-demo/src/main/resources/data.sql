INSERT INTO DEPARTMENT (ID, NAME) VALUES (1, 'DC');
INSERT INTO DEPARTMENT (ID, NAME) VALUES (2, 'Marvel');
INSERT INTO DEPARTMENT (ID, NAME) VALUES (3, 'Tiny Deparment');

INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (1, 'Batman', 'A00001A', 4.1, 1);
INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (2, 'Superman', 'A00002B', 3.5,  1);
INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (3, 'Wonder Woman', 'A00003C', 2.5, 1);
INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (4, 'Flash', 'A00004D', 2.1, 1);
INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (5, 'Green Lantern', 'A00005E', 3.7, 1);
INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (6, 'Iron Man', 'A00006F', 4.7, 2);
INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (7, 'Captain America', 'A00007G', 2.6, 2);
INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (8, 'Black Widow', 'A00008H', 3.6, 2);
INSERT INTO STUDENT (ID, NAME, MATRIC_NO, CAP, DEPARTMENT_ID) VALUES (9, 'Hulk', 'A00009I', 3.0, 2);


INSERT INTO COURSE (ID, C_CODE, DESCRIPTION) VALUES (1, 'Java', 'Programming with Java');
INSERT INTO COURSE (ID, C_CODE, DESCRIPTION) VALUES (2, 'SQL', 'Data Modelling with SQL');
INSERT INTO COURSE (ID, C_CODE, DESCRIPTION) VALUES (3, 'C#', 'Programming with C#');
INSERT INTO COURSE (ID, C_CODE, DESCRIPTION) VALUES (4, 'Big Data', 'Big Data with Python');

INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (1, 1);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (2, 1);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (3, 1);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (4, 1);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (5, 1);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (3, 2);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (4, 2);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (5, 2);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (6, 2);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (7, 2);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (8, 2);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (6, 3);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (7, 3);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (8, 3);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (9, 3);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (10, 3);