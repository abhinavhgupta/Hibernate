package com.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="employee",cascade= CascadeType.ALL, orphanRemoval=true)
	List<Training> training = new ArrayList<Training>();

	public List<Training> getTraining() {
		return training;
	}

	public void setTraining(List<Training> training) {
		this.training = training;
	}


	public Employee() {
		super();
	}


	public Employee(String employeeName, String role) {
		super();
		this.employeeName = employeeName;
		this.role = role;
	}
	

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getRole() {
		return role;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public void setRole(String role) {
		this.role = role;
	}

}
