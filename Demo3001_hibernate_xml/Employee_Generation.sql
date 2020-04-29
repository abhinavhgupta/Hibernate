DROP database hibernatedemos;

CREATE database hibernatedemos;

USE hibernatedemos;

DROP TABLE IF EXISTS Employee;

CREATE TABLE `employee` (
  `EMPLOYEEID` int(11) NOT NULL,
  `EMPLOYEENAME` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  `SALARY` double DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEEID`)
);

