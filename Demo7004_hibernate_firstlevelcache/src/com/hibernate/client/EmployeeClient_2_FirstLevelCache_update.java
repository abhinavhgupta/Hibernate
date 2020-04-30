package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_2_FirstLevelCache_update {
	public static void main(String[] args) {
		Employee employee = null;
		
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		System.out.println("is Employee ID 1003 is in first level cache - before? "+session.contains(employee));
		employee= session.get(Employee.class, 1003);
		System.out.println("is Employee ID 1003 is in first level cache - after? "+session.contains(employee));
		System.out.println(employee.getEmployeeId()+", "+employee.getEmployeeName());
		
		
		System.out.println("is Employee ID 1003 is in first level cache - second time invoked - after? "+session.contains(employee));
		employee.setEmployeeName("Jagadish_new"); //because of the object is available in first level cache managed by session, so update happened on the object
		employee = session.get(Employee.class, 1003);
		System.out.println("is Employee ID 1003 is in first level cache - second time invoked - after second print? "+session.contains(employee));
		System.out.println(employee.getEmployeeId()+", "+employee.getEmployeeName());
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtility.shutdownSessionFactory();
	}

}
//Observation:  output in the console with update employeeName for 1003 and it's associated updated query