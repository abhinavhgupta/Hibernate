package com.hibernate.client;

import java.time.LocalDate;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Employee employee = new Employee("Rahul","Analyst",LocalDate.now(),600000); //transient object
		session.beginTransaction();
		session.save(employee); //Persist object
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
