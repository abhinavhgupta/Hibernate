package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient2_PersistentToDetached {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Employee employee = new Employee("Rahul","Analyst",570000); //transient object
		
		session.beginTransaction();
		session.save(employee); //Persist object
		session.getTransaction().commit();
		
		//System.out.println("Employee Frist Name: "+employee.getEmployeeName());
		
		session.evict(employee); //detached object when called evict on the object

		//employee = session.get(Employee.class, 1);
		employee.setEmployeeName("New-Rahul");
		
		System.out.println("Employee First Name: "+session.get(Employee.class,1)); //for example only, because of detached state with the same session 
																				//not able to retrieve the employee object
		//session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
//No commit after evict() so it will show the process is running in console, terminate manually the process.