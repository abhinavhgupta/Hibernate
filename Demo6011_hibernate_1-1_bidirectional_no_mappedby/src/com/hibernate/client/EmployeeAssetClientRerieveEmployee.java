package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeAssetClientRerieveEmployee {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Employee> empList = new ArrayList<Employee>();
		
		System.out.println("=====Through Employee====");
		//Query query = session.createQuery("from Employee",Employee.class);
		TypedQuery<Employee> query = session.createQuery("from Employee",Employee.class);
		empList = query.getResultList();
		for (Employee e : empList) {
			System.out.println(e.getEmployeeId()+", "+e.getEmployeeName()+", "+e.getAsset().getAssetName()+", "+e.getAsset().getAssetBrandName());
		}
		
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
