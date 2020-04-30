DROP DATABASE IF EXISTS hibernatedemos;

CREATE DATABASE hibernatedemos;

USE hibernatedemos;


create table EMPLOYEE (EMPLOYEE_ID integer not null auto_increment,
EMPLOYEENAME varchar(255), 
ROLE varchar(255), 
primary key (EMPLOYEE_ID));
create table TRAINING (trainingId integer not null auto_increment, 
trainingName varchar(255),
employeeId integer, 
primary key (trainingId));
alter table TRAINING add constraint FKmeft4xym3395po79m2a98m3s6 foreign key (employeeId) references EMPLOYEE (EMPLOYEE_ID);


 

--insert into training values(1,"Spring MVC",1001);
--insert into employee values(1001,"Ravi",1);

 
 
 
 