DROP DATABASE IF EXISTS hibernatedemos;

CREATE DATABASE hibernatedemos;

USE hibernatedemos;

 create table ASSET (
 ASSET_ID integer not null auto_increment, 
 assetBrandName varchar(255), 
 assetName varchar(255),
 primary key (ASSET_ID)) engine=InnoDB;
 
 create table EMPLOYEE (
 EMPLOYEE_ID integer not null auto_increment,
 EMPLOYEENAME varchar(255), 
 ROLE varchar(255),
 ASSET_ID integer, 
 primary key (EMPLOYEE_ID)) engine=InnoDB;
 
 alter table EMPLOYEE add constraint FK6fg5jxcsjb12kpkemv5v0pfdy foreign key (ASSET_ID) references ASSET (ASSET_ID);
 
 
 
 
 
 