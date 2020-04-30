package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE") //display table name in the database
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	@Column(name="EMPLOYEENAME") //display column name in the table
	private String employeeName;
	@Column(name="ROLE")
	private String role;
	
	@OneToOne
	@JoinColumn(name="ASSET_ID")
	Asset asset;

	public Employee() {
		super();
	}


	public Employee(String employeeName, String role) {
		super();
		this.employeeName = employeeName;
		this.role = role;
	}
	
	public Asset getAsset() {
		return asset;
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

	public void setAsset(Asset asset) {
		this.asset = asset;
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
