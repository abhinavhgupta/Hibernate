package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TRAINING")
public class Training {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int trainingId;
	private String trainingName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employeeId")
	Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Training() {
	}

	public Training(String trainingName) {
		this.trainingName = trainingName;
	}


	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	
	

}
