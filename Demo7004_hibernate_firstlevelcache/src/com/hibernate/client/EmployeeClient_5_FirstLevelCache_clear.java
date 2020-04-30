package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_5_FirstLevelCache_clear {

	public static void main(String[] args) {
		Employee employee = null;
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		
		Employee employee1 = session.get(Employee.class, 1002);
		System.out.println(employee1.getEmployeeId()+", "+employee1.getEmployeeName());
		
		Employee employee2 = session.get(Employee.class, 1003);
		System.out.println(employee2.getEmployeeId()+", "+employee2.getEmployeeName());
		
		session.clear(); //Removes employeeid's 1002 and 1003
		
		Employee employee3 = session.get(Employee.class, 1002);
		System.out.println(employee3.getEmployeeId()+", "+employee3.getEmployeeName());
		
		Employee employee4 = session.get(Employee.class, 1003);
		System.out.println(employee4.getEmployeeId()+", "+employee4.getEmployeeName());
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtility.shutdownSessionFactory();
	}

}
//Observation:  two times the same query fired  by the framework, because called clear method after loading the object
//associated object/s in the session will be cleared/removed from the current session