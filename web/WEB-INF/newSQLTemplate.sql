Drop table PROJECTS_IN_QUARTERS;
Drop table PROJECT;
Drop table QUARTER;
Drop table USERS;
Drop table PARTNER;
Drop table EMPLOYEE;

Drop sequence PROJECT_ID_SEQUENCE;
Drop sequence USER_ID_SEQUENCE;
Drop sequence PARTNER_ID_SEQUENCE;
Drop sequence EMPLOYEE_ID_SEQUENCE;

Create Sequence EMPLOYEE_ID_SEQUENCE;
Create Sequence PARTNER_ID_SEQUENCE;
Create Sequence USER_ID_SEQUENCE;
Create Sequence PROJECT_ID_SEQUENCE;

Create table EMPLOYEE(
EMPLOYEE_ID int PRIMARY KEY,
FIRSTNAME VARCHAR2(20) NOT NULL,
LASTNAME VARCHAR2(20) NOT NULL,
COUNTRY VARCHAR2(10) NOT NULL,
EMPLOYEE_TYPE VARCHAR2(20) NOT NULL
);

create table PARTNER(
PARTNER_ID INT,
COUNTRY VARCHAR2(10) NOT NULL,
PARTNER_NAME VARCHAR2(80) NOT NULL,
PARTNER_TYPE VARCHAR2(20) NOT NULL,
PRIMARY KEY (PARTNER_ID)
);

create table USERS(
USER_ID INT PRIMARY KEY,
USERNAME VARCHAR2(20) NOT NULL,
PASSWORD VARCHAR2(20) NOT NULL,
FIRSTNAME VARCHAR2(20) NOT NULL,
LASTNAME VARCHAR2(20) NOT NULL,
USER_TYPE VARCHAR2(10) NOT NULL,
PARTNER_ID INT,
EMPLOYEE_ID INT,
FOREIGN KEY (PARTNER_ID) REFERENCES PARTNER,
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE
);

create table QUARTER(
QUARTER_NAME VARCHAR2(6) PRIMARY KEY,
QUARTER_BUDGET INT
);

Create table PROJECT(
PROJECT_ID INT,
STATUS VARCHAR2(20) NOT NULL,
ACTIVITY_DESCRIPTION VARCHAR2(100) NOT NULL,
COMMENTS VARCHAR2(1000),
TARGET_AUDIENCE VARCHAR2(30) NOT NULL,
PROJECT_BUDGET INT NOT NULL,
PROJECT_COST INT,
CURRENCY VARCHAR2(4),
START_DATE DATE NOT NULL, 
END_DATE DATE NOT NULL,
OBJECTIVE_RESULT VARCHAR2(400) NOT NULL,
REQUIRED_POE VARCHAR2(400),
PARTNER_ID INT,
EMPLOYEE_ID INT,
QUARTER_NAME VARCHAR2(6),
PRIMARY KEY (PROJECT_ID),
FOREIGN KEY (PARTNER_ID) REFERENCES PARTNER,
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE,
FOREIGN KEY (QUARTER_NAME) REFERENCES QUARTER
);



CREATE TABLE PROJECTS_IN_QUARTERS(
PROJECT_ID INT,
QUARTER_NAME VARCHAR2(6),
PRIMARY KEY(QUARTER_NAME, PROJECT_ID)
);

INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, COUNTRY, EMPLOYEE_TYPE) VALUES (1,'PERNILLE', 'JACOBSEN', 'DENMARK', 'DELL mdf');
INSERT INTO PARTNER (PARTNER_ID, COUNTRY, PARTNER_NAME, PARTNER_TYPE) VALUES (1, 'DENMARK', 'JEANETTE', 'CPHBUSINESS');
INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, COUNTRY, EMPLOYEE_TYPE) VALUES (0, 'DUMMY', 'DUMMY', 'DUMMY', 'DUMMY');
INSERT INTO PARTNER (PARTNER_ID, COUNTRY, PARTNER_NAME, PARTNER_TYPE) VALUES (0, 'DUMMY', 'DUMMY', 'DUMMY');
INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, USER_TYPE, PARTNER_ID, EMPLOYEE_ID) VALUES (0, 'group_08_2sem', 'group_08_2sem', 'DUMMY', 'DUMMY', 'DUMMY', '0','0');

commit;


