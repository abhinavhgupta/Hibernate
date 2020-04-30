CREATE database hibernatedemos;

USE hibernatedemos;


DROP TABLE IF EXISTS CreditAccount;
DROP TABLE IF EXISTS DebitAccount;

create table CreditAccount (id integer not null, 
balance double precision not null,
interestRate double precision not null,
owner varchar(255), 
creditLimit double precision not null,
primary key (id));

create table DebitAccount (id integer not null, 
balance double precision not null,
interestRate double precision not null, 
owner varchar(255), 
overdraftFee double precision not null, 
primary key (id));