package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Department dept = new Department("LKM");
		
		Employee employee1 = new Employee("Rahul","Analyst"); //transient object
		Employee employee2 = new Employee("John","Analyst");
		
		employee1.setDepartment(dept);
		employee2.setDepartment(dept);
		
		session.beginTransaction();
		session.save(employee1);
		session.save(employee2);//Persist object, persisting employee because cascadeType.ALL
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
