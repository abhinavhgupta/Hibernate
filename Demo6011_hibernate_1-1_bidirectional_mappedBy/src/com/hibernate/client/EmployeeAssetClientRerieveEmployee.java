package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeAssetClientRerieveEmployee {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Employee> list = new ArrayList<Employee>();
		
		Query query = session.createQuery("from Employee");
		list = query.getResultList();
		for (Employee e : list) {
			System.out.println(e.getEmployeeId()+", "+e.getEmployeeName()+", "+e.getAsset().getAssetName()+", "+e.getAsset().getAssetBrandName());
		}
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
