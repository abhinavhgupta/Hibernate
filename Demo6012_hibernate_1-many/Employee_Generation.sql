DROP DATABASE IF EXISTS hibernatedemos;

CREATE DATABASE hibernatedemos;

USE hibernatedemos;
Hibernate: create table EMPLOYEE (
EMPLOYEE_ID integer not null auto_increment,
EMPLOYEENAME varchar(255),
ROLE varchar(255), 
primary key (EMPLOYEE_ID)) engine=InnoDB;
create table EMPLOYEE_TRAINING (
Employee_EMPLOYEE_ID integer not null, 
training_trainingId integer not null) engine=InnoDB;
create table TRAINING (
trainingId integer not null auto_increment, 
trainingName varchar(255),
primary key (trainingId)) engine=InnoDB;
alter table EMPLOYEE_TRAINING drop index UK_ci1r69uoxmjf1cjnn848k6cu6;
alter table EMPLOYEE_TRAINING add constraint UK_ci1r69uoxmjf1cjnn848k6cu6 unique (training_trainingId);
alter table EMPLOYEE_TRAINING add constraint FKggmgpa1rghi0760pvoidjtyyk foreign key (training_trainingId) references TRAINING (trainingId);
alter table EMPLOYEE_TRAINING add constraint FK36xxgheu9w746bclhroqfc6mf foreign key (Employee_EMPLOYEE_ID) references EMPLOYEE (EMPLOYEE_ID);
 
 
 
 
 
 