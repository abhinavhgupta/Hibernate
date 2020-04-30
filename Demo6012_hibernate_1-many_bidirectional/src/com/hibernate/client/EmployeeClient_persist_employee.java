package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Training;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_persist_employee {

	public static void main(String[] args) {
	insert();
	}
	
	public static void insert() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Training> trainingList;
		Training t1 = new Training("Spring Boot");
		Training t2 = new Training("Spring Boot Micro services");
		Employee employee = new Employee("Rahul","Analyst"); //transient object
		
		trainingList = new ArrayList<>();
		trainingList.add(t1);
		trainingList.add(t2);
		
		t1.setEmployee(employee);
		t2.setEmployee(employee);
		
		employee.setTraining(trainingList);
		
		session.beginTransaction();
		session.save(employee); //Persist object, persisting employee because cascadeType.ALL
		session.getTransaction().commit();
		System.out.println("record inserted!!");
		session.close();
		
		HibernateUtility.shutdownSessionFactory();
	}

}
