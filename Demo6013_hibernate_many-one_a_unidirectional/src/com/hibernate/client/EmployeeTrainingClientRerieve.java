package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;
@SuppressWarnings("unchecked")
public class EmployeeTrainingClientRerieve {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Employee> list = new ArrayList<Employee>();
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
