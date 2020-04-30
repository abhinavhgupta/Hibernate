DROP database if exists hibernatedemos;
CREATE database hibernatedemos;

USE hibernatedemos;

create table Account (id integer not null, 
balance double not null, 
interestRate double not null, 
owner varchar(255),
primary key (id));

create table CreditAccount (id integer not null, 
balance double not null, 
interestRate double not null,
owner varchar(255),
creditLimit double not null,
primary key (id));

create table DebitAccount (id integer not null,
balance double not null,
interestRate double not null, 
owner varchar(255),
overdraftFee double not null, 
primary key (id));


insert into DebitAccount values (1001, 2000, 2.5, BDC, 100);
insert into DebitAccount values (1002, 3000, 2.5, CDC, 200);

insert into DebitAccount values (1003, 2000, 3.5, MDC, 300);
insert into DebitAccount values (1004, 4000, 4.5, KDC, 400);

