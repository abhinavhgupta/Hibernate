package com.hibernate.client;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

@SuppressWarnings("unchecked")
public class EmployeeHQLClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();

		// =====Step1=====
		
		  Query query = session.createQuery("from Employee"); 
		  List<Employee> employees = query.getResultList();
		  employees.stream().forEach(System.out::println);
		 

		// =====Step2=====
		// ====Filtering===
		
		 /* Query query =  session.createQuery("from Employee e where e.employeeId=1002 ");
		  List<Employee> employees = query.getResultList();
		  employees.stream().forEach(System.out::println);*/
		 
		
		
		// =====Step3=====
		// ====parameter passing=== 
		/*
		 Query query =session.createQuery("from Employee e where e.employeeName= :name ").setParameter("name", "Manoj"); 
		 List<Employee> employees =	 query.getResultList(); 
		 employees.stream().forEach(System.out::println);
		 */
		
		// =====Step3=====
		// ====paging - displaying no of rows/records as per the requirement
		//=== Description: start displaying the results after that row - setFirstResult()
		//===and display number of rows from there- setMaxResults();
		
		/*  Query query = session.createQuery("from Employee") 
				  				.setFirstResult(4)
				  				.setMaxResults(2); 
		  List<Employee> employees = query.getResultList();
		  employees.stream().forEach(System.out::println); */
		 

		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
