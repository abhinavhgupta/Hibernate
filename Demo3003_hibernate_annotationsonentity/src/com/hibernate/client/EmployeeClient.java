package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new Employee("John","Sr.Analyst",57000)); //Persisting of employee
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	
	}

}
