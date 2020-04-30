package com.hibernate.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Meetings")
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;

	@Column(name = "meeting_date")
	private LocalDate meeting_date;

	@ManyToMany(mappedBy = "meetings")
	List<Employee> employees = new ArrayList<Employee>();

	public Meeting() {
		// TODO Auto-generated constructor stub
	}

	public Meeting(LocalDate meeting_date) {
		super();
		this.meeting_date = meeting_date;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public LocalDate getMeeting_date() {
		return meeting_date;
	}

	public int getMid() {
		return mid;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void setMeeting_date(LocalDate meeting_date) {
		this.meeting_date = meeting_date;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Meeting [mid=" + mid + ", meeting_date=" + meeting_date + ", employees=" + employees + "]";
	}

}
