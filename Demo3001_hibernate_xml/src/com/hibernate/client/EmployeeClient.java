package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = new Employee();
		//session.save(new Employee("Rahul","Kumar",50000)); //Persisting of Employee
		
		employee.setEmployeeName("Tina");
		employee.setRole("Sr.Analyst");
		employee.setSalary(850000);
		
		Employee employee1 = new Employee("Meena", "Analyst", 650000);
		Employee employee2 = new Employee("Leena", "Team Lead", 1650000);
		
		session.save(employee);
		session.save(employee1);
		session.save(employee2);
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
		
	}
}
