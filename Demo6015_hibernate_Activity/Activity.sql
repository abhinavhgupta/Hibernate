DROP DATABASE IF EXISTS hibernatedemos;

CREATE DATABASE hibernatedemos;

USE hibernatedemos;

create table EMPLOYEE (EMPLOYEE_ID integer not null auto_increment,
EMPLOYEENAME varchar(255), 
ROLE varchar(255), 
primary key (EMPLOYEE_ID));


create table Meetings (mid integer not null auto_increment,
meeting_date date, 
primary key (mid));


create table employee_meeting (employeeId integer not null,
mid integer not null);


 alter table employee_meeting add constraint FK8rkjaspotjgr596cs98h006cq foreign key (mid) references Meetings (mid);
 
alter table employee_meeting add constraint FK6lp5ni9uxuv97ddlpr4yvo174 foreign key (employeeId) references EMPLOYEE (EMPLOYEE_ID);
 