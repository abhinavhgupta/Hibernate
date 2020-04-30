CREATE database hibernatedemos;

USE hibernatedemos;


DROP TABLE IF EXISTS account;


CREATE TABLE `account` (
  `DTYPE` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `balance` double NOT NULL,
  `interestRate` double NOT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `overdraftFee` double DEFAULT NULL,
  `creditLimit` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);
