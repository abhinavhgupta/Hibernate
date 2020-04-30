package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Asset;
import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Asset asset = new Asset("Laptop","DELL");
		Employee employee = new Employee("Rahul","Analyst"); //transient object
		employee.setAsset(asset);
		session.beginTransaction();
		
		session.save(asset); //Persist  asset object
		session.save(employee); //Persist employee object
		
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
