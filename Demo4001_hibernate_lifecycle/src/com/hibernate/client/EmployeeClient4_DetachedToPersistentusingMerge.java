package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient4_DetachedToPersistentusingMerge {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Employee employee = new Employee("Rahul","Analyst",570000); //transient object
		session.beginTransaction();
		session.save(employee); //Persist object
		session.getTransaction().commit();
		//session.evict(employee); //detached object when called evict() on the object
		session.close(); //detached object when called close() on the object
		
		Session session1 = HibernateUtility.getSessionFactory().openSession();
		session1.beginTransaction();
		employee.setSalary(600000);
		session1.merge(employee); //attach state => detached to attached
		session1.getTransaction().commit();
		employee = session1.get(Employee.class, 1003);
		System.out.println("Employee First Name: "+employee.getEmployeeName()); 
		System.out.println("Employee Salary: "+employee.getSalary());
		session1.close();
		HibernateUtility.shutdownSessionFactory();
		
	}

}
