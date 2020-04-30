DROP DATABASE IF EXISTS hibernatedemos;

CREATE DATABASE hibernatedemos;

USE hibernatedemos;

DROP TABLE IF EXISTS Employee;

CREATE TABLE `employee` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEENAME` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  `SALARY` double DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into employee values(1001,'Manoj','Analyst',900000);
insert into employee values(1002,'Hari','Sr.Analyst',800000);
insert into employee values(1003,'Jagadish','Sr.Analyst',900000);
insert into employee values(1004,'Aatika','TL',950000);
insert into employee values(1005,'Suneetha','TL',950000);