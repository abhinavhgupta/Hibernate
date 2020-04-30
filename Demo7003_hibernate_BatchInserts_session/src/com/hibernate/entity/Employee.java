package com.hibernate.entity;

import java.io.Serializable;

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
	@Column(name="SharesForEmployee")
	private int shares;
	
	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public int getShares() {
		return shares;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", shares=" + shares + "]";
	}

}
