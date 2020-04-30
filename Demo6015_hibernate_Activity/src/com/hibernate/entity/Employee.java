package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE") // display table name in the database
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;
	@Column(name = "EMPLOYEENAME") // display column name in the table
	private String employeeName;
	@Column(name = "ROLE")
	private String role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_ID")
	Location location;

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", role=" + role + "]";
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
