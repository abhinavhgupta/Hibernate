package com.hibernate.client;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

@SuppressWarnings("unchecked")
public class EmployeeHCQLClient {

	/**
	 * @param args
	 */

	static Session session = HibernateUtility.getSessionFactory().openSession();
	static CriteriaBuilder builder = session.getCriteriaBuilder();

	public static void main(String[] args) {

		session.beginTransaction();

		// =====Step1=====
		// =====Fetching all the employee details using CriteriaQuery======
		/*CriteriaQuery<Employee> cqe = builder.createQuery(Employee.class);
		Root<Employee> root = cqe.from(Employee.class);
		cqe.select(root);
		List<Employee> employees = session.createQuery(cqe).getResultList();
		employees.stream().forEach(System.out::println);*/

		// =====Step2=====
		// ====Filtering===
		// ====Fetching only the employeeNames using get() of Root
		
		/*CriteriaQuery<String> cqe = builder.createQuery(String.class);
		Root<Employee> croot = cqe.from(Employee.class);
		cqe.select(croot.get("employeeName"));
		List<String> employees = session.createQuery(cqe).getResultList();
		employees.stream().forEach(System.out::println);*/
		 

		// =====Step3=====
		// ====Using TypedQuery===
		
		/*  CriteriaQuery<String> cqe = builder.createQuery(String.class); Root<Employee>
		  croot = cqe.from(Employee.class); 
		  cqe.select(croot.get("employeeName"));
		  //The type of the criteria query (aka the <T>) indicates the expected types in the query result. 
		  //This might be an entity, an Integer, or any other object. 
		  TypedQuery<String> typedQuery = session.createQuery(cqe);
		  List<String> empNames = typedQuery.getResultList();
		  empNames.stream().forEach(System.out::println);*/
		 

		// =====Step4=====
		// =====Retrieve employeeid, employeeName and salary using TypedQuery=====
		
		CriteriaQuery<Employee[]> cqe = builder.createQuery(Employee[].class);
		Root<Employee> croot = cqe.from(Employee.class);
		cqe.multiselect(croot.get("employeeId"), croot.get("employeeName"), croot.get("salary"));
		TypedQuery<Employee[]> typedQuery = session.createQuery(cqe);
		System.out.println("Employee ID, Employee Name , Salary");
		List<Employee[]> empIdNameAndSalary = typedQuery.getResultList();
		for (Object[] objects : empIdNameAndSalary) {
			System.out.println(objects[0] + ", " + objects[1] + ", " + objects[2]);
		}
		 

		// =====Step5=====
		// ====retrieve employees whose salary in between 700000.0, 900000.0
		/*
		 * CriteriaQuery<Employee> cqe = builder.createQuery(Employee.class);
		 * Root<Employee> croot = cqe.from(Employee.class); CriteriaQuery<Employee>
		 * salaryRange =
		 * cqe.select(croot).where(builder.between(croot.get("salary"),700000.0,
		 * 800000.0)); List<Employee> employees =
		 * session.createQuery(cqe).getResultList();
		 * employees.stream().forEach(System.out::println);
		 */

		// =====Step5=====
		// ====retrieve employees whose salary in between 700000.0, 900000.0
		/*
		 * CriteriaQuery<Employee> cqe = builder.createQuery(Employee.class);
		 * Root<Employee> croot = cqe.from(Employee.class); CriteriaQuery<Employee>
		 * salaryRange = cqe.select(croot)
		 * .where(builder.between(croot.get("salary"),700000.0, 800000.0))
		 * .orderBy(builder.asc(croot.get("salary"))); //change asc to desc
		 * List<Employee> employees = session.createQuery(cqe).getResultList();
		 * employees.stream().forEach(System.out::println);
		 */

		// =====Step6=====
		// ====Aggregate functions
		/*
		 * CriteriaQuery<Long> cqe = builder.createQuery(Long.class); Root<Employee>
		 * croot = cqe.from(Employee.class); cqe.multiselect(builder.count(croot));
		 * List<Long> employeesCount = session.createQuery(cqe).getResultList();
		 * System.out.println(employeesCount);
		 */

		// =====Step6=====
		// ====Aggregate functions - Average salary of the employees
		/*
		 * CriteriaQuery<Double> cqe = builder.createQuery(Double.class); Root<Employee>
		 * croot = cqe.from(Employee.class);
		 * cqe.multiselect(builder.avg(croot.get("salary"))); //change avg to
		 * min/max/sum etc List<Double> employeesAvgSalary =
		 * session.createQuery(cqe).getResultList();
		 * System.out.println(employeesAvgSalary);
		 */

		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
