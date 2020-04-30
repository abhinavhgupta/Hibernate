package com.hibernate.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Training;
import com.hibernate.utility.HibernateUtility;

public class EmployeeTrainingClientRerieve {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Employee> list = new ArrayList<Employee>();
		
		Query query = session.createQuery("from Employee");
		list = query.getResultList();
		for (Employee employee : list) {
			System.out.println(employee.getEmployeeId()+", "+employee.getEmployeeName());
			Collection<Training> trainings = employee.getTraining();
			/*for (Training e : trainings) {
				System.out.println(e.getTrainingId()+", "+e.getTrainingName());
			}*/
			
			trainings.stream().map(e->e.getTrainingName()).forEach(System.out::println);
			System.out.println("============================");
		}
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
