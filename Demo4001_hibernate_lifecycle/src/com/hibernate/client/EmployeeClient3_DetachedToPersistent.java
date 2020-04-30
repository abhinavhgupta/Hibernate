package com.accenture.lkm.hibernate.client;

import org.hibernate.Session;

import com.accenture.lkm.hibernate.entity.Employee;
import com.accenture.lkm.hibernate.utility.HibernateUtility;

public class EmployeeClient3_DetachedToPersistent {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Employee employee = new Employee("Rahul","Analyst",570000); //transient object
		session.beginTransaction();
		session.save(employee); //Persist object
		session.getTransaction().commit();
		session.evict(employee); //detached object when called evict on the object
	//	employee = session.get(Employee.class, 1003);
	//	System.out.println("Employee First Name: "+employee.getEmployeeName()); //for example only, because of detached state with the same session 
																				//not able to retrieve the employee object
		session.beginTransaction();
		employee.setSalary(60000);
		session.update(employee); //attach state => detached to attached
		session.getTransaction().commit();
		session.evict(employee);
		employee = session.get(Employee.class, 1);
		System.out.println("Employee Frist Name: "+employee.getEmployeeName()); 
		System.out.println("Employee Salary: "+employee.getSalary());
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
