package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_1_secondlevelcache {

	public static void main(String[] args) {
		Session session1 = HibernateUtility.getSessionFactory().openSession();
		
		session1.getTransaction().begin();
		
		System.out.println("============Session1==============");
		Employee employee1 = session1.load(Employee.class, 1003);
		System.out.println(employee1.getEmployeeId()+", "+employee1.getEmployeeName());
		
		session1.getTransaction().commit();
		session1.close();
			
		
		Session session2 = HibernateUtility.getSessionFactory().openSession();
		session2.getTransaction().begin();
		
		System.out.println("============Session2==============");
		Employee employee2 = session2.load(Employee.class, 1003);
		System.out.println(employee2.getEmployeeId()+", "+employee2.getEmployeeName());
		
		session2.getTransaction().commit();
		session2.close();
		
		HibernateUtility.shutdownSessionFactory();
		
	}

}
