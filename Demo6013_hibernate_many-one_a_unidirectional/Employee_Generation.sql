DROP DATABASE IF EXISTS hibernatedemos;

CREATE DATABASE hibernatedemos;

USE hibernatedemos;

CREATE TABLE EMPLOYEE (
EMPLOYEE_ID integer not null auto_increment,
EMPLOYEENAME varchar(255),
ROLE varchar(255), 
primary key (EMPLOYEE_ID)) engine=InnoDB;

CREATE TABLE TRAINING (
trainingId integer not null auto_increment, 
trainingName varchar(255),
employee_EMPLOYEE_ID integer, 
primary key (trainingId)) engine=InnoDB;

ALTER TABLE TRAINING add constraint FK6k2l789657v15jfguigdbea5i foreign key (employee_EMPLOYEE_ID) references EMPLOYEE (EMPLOYEE_ID);
 

insert into training values(1,"Spring MVC",1001);
insert into employee values(1001,"Ravi",1);

ins
 
 
 
 