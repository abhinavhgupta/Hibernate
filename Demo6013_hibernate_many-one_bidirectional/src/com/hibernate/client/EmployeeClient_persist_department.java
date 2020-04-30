package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_persist_department {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Employee> employees = new ArrayList<Employee>();
		
		Department dept = new Department("LKM");
		
		Employee employee1 = new Employee("Rahul","Analyst"); //transient object
		Employee employee2 = new Employee("John","Analyst");
		employees.add(employee1);
		employees.add(employee2);
		
		dept.setEmployee(employees);
		
		session.beginTransaction();
		session.save(dept);//Persist object, persisting employee because cascadeType.ALL
		session.getTransaction().commit();
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
