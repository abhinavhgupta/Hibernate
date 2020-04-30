DROP database if exists hibernatedemos;
CREATE database hibernatedemos;

USE hibernatedemos;

DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS debitaccount;
DROP TABLE IF EXISTS creditaccount;


CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `balance` double NOT NULL,
  `interestRate` double NOT NULL,
  `owner` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `debitaccount` (
  `overdraftFee` double NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKia914478noepymc468kiaivqm` FOREIGN KEY (`id`) REFERENCES `account` (`id`)
);

CREATE TABLE `creditaccount` (
  `creditLimit` double NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKihw8h3j1k0w31cnyu7jcl7n7n` FOREIGN KEY (`id`) REFERENCES `account` (`id`)
);
