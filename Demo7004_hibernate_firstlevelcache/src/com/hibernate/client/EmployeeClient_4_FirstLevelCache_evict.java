package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_4_FirstLevelCache_evict {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		
		Employee employee1 = session.get(Employee.class, 1002);
		System.out.println(employee1.getEmployeeId()+", "+employee1.getEmployeeName());
		
		Employee employee2 = session.get(Employee.class, 1003);
		System.out.println(employee2.getEmployeeId()+", "+employee2.getEmployeeName());
		
		session.evict(employee2); //A single associated object will be evicted from the session
		
		Employee employee3 = session.get(Employee.class, 1002);
		System.out.println(employee3.getEmployeeId()+", "+employee3.getEmployeeName());
		
		Employee employee4 = session.get(Employee.class, 1003);
		System.out.println(employee4.getEmployeeId()+", "+employee4.getEmployeeName());
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtility.shutdownSessionFactory();
	}

}
//Observation:  two times the same query fired  by the framework, because called evict method after loading the object
//associated object in the session will be cleared/removed from the current session