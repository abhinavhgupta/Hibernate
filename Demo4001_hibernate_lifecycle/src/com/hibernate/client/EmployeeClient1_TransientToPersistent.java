package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient1_TransientToPersistent {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Employee employee = new Employee("Rahul","Analyst",570000); //transient object
		//session.beginTransaction();
		
		session.getTransaction().begin();
		session.save(employee); //Persist object
		session.getTransaction().commit(); //employee state saved to database
		// an employee object will continue to be in persistence context after save 
		employee.setEmployeeName("New-Rahul"); // employee name update in persistence context 
		System.out.println("Employee First Name: "+session.get(Employee.class,1003)); //employee object
		//retrieved from persistence context		
		//select query not fired, observe the database and hibernate logs		
		session.getTransaction().commit(); //updated employee object stored in database, observe the database
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
