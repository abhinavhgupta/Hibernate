package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_loadmethod {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = session.load(Employee.class, 1003);
		System.out.println(employee.getEmployeeId()+", "+employee.getEmployeeName());
		/*if(employee != null) {
			System.out.println(employee.getEmployeeId()+", "+employee.getEmployeeName());
		}*/	
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
