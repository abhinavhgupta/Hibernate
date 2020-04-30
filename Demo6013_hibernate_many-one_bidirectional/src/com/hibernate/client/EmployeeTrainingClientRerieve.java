package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeTrainingClientRerieve {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Employee> list = new ArrayList<Employee>();
		List<Department> depts = new ArrayList<Department>();
		
		
		Query query = session.createQuery("from Employee");
		list = query.getResultList();
		System.out.println("==== EmployeeID, EmployeeName, DepartmentName====");
		for (Employee employee : list) {
			System.out.println(employee.getEmployeeId()+", "+employee.getEmployeeName()+", "+employee.getDepartment().getDeptName());
		}
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
