package com.hibernate.entity;

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
@Table(name = "LOCATION")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID")
	private Integer locationId;
	private Integer locationNo;
	private String locationName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	public Location(Integer locationNo, String locationName) {
		super();
		this.locationNo = locationNo;
		this.locationName = locationName;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getLocationNo() {
		return locationNo;
	}

	public void setLocationNo(Integer locationNo) {
		this.locationNo = locationNo;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
