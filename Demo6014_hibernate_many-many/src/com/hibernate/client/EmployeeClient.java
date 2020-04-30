package com.hibernate.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Meeting;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		
		LocalDate date1 = LocalDate.of(2020, 03, 18);
		Meeting m1 = new Meeting();
		m1.setMeeting_date(date1);
		Meeting m2 = new Meeting();
		LocalDate date2 = LocalDate.of(2020, 03, 19);
		m2.setMeeting_date(date2);
		
		
		List<Meeting> meetings = new ArrayList<Meeting>();
		
		meetings.add(m1);
		meetings.add(m2);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee employee1 = new Employee("Hari","Sr.Analyst"); //transient object
		Employee employee2 = new Employee("Jagadish","Sr.Analyst");
		Employee employee3 = new Employee("Manoj","TL");
		
		employee1.setMeetings(meetings);
		employee2.setMeetings(meetings);
		employee3.setMeetings(meetings);
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		session.beginTransaction();
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);//Persist object, persisting employee because cascadeType.ALL
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
