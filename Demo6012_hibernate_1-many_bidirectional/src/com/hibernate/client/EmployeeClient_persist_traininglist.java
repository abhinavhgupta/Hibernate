package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Training;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_persist_traininglist {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Training> trainingList;

		Training t1 = new Training("Spring Boot");
		Training t2 = new Training("Spring Boot Micro services");
		
		Employee employee = new Employee("Rahul", "Analyst"); // transient object

		trainingList = new ArrayList<>();
		
		t1.setEmployee(employee);
		t2.setEmployee(employee);
		
		trainingList.add(t1);
		trainingList.add(t2);

		session.beginTransaction();
		session.save(t1);
		session.save(t2); // Persist object, persisting training objects because cascadeType.ALL
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
