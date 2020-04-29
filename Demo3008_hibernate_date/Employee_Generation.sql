DROP DATABASE IF EXISTS hibernatedemos;

CREATE DATABASE hibernatedemos;

USE hibernatedemos;

DROP TABLE IF EXISTS employee;

CREATE TABLE `employee` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEENAME` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  `DATEOFJOINING` date,
  `SALARY` double DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into employee values(1001,'ABC','Analyst','2018-02-03',500000);
insert into employee values(1002,'Kiran','Sr.Analyst','2018-03-04',800000);