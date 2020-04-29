package com.hibernate.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE") //display table name in the database
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	@Column(name="EMPLOYEENAME") //display column name in the table
	private String employeeName;
	@Column(name="ROLE")
	private String role;
	@Column(name="DATEOFJOINING") // if it is hibernate 4 need to use of @Temporal or manually convert the util type to sql type.
	// from hibernate 5 supporting java8 so work with java.time and its specification like LocalDateTime, LocalDate etc.
	// no need of any other annotaions, works in hibernate5.2, but for 5.1 requires hibernate-java8.jar
	private LocalDate joiningDate;
	@Column(name="SALARY")
	private double salary;

	public Employee() {
		super();
	}

	public Employee(String employeeName, String role, LocalDate date,double salary) {
		super();
		this.employeeName = employeeName;
		this.role = role;
		this.joiningDate = date;
		this.salary = salary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public String getRole() {
		return role;
	}

	public double getSalary() {
		return salary;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}



}
