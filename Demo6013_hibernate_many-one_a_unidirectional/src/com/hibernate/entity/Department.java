package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
public class Department {
	
	@Id
	@GeneratedValue
	private Integer deptId;
	@Column(name="departmentname")
	private String deptName;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}
	
	public Integer getDeptId() {
		return deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

}
