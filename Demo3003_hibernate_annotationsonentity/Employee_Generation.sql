DROP DATABASE IF EXISTS hibernatedemos;

CREATE DATABASE hibernatedemos;

USE hibernatedemos;

DROP TABLE IF EXISTS Employee;

CREATE TABLE `employee` (
  `EMPLOYEEID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEENAME` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  `SALARY` double DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into employee values(1001,'ABC','Analyst',500000);