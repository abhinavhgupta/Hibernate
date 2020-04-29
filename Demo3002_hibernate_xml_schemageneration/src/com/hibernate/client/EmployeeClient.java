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
		employee.setEmployeeName("Rahul");;
		employee.setRole("Sr.Analyst");
		employee.setSalary(800000);
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
		
	}

}
