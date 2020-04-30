package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Asset;
import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient1 {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Asset asset = new Asset("Laptop","DELL");
		Employee employee = new Employee("Rahul","Analyst"); //transient object
		employee.setAsset(asset);
		asset.setEmployee(employee);
		session.beginTransaction();
		//session.save(asset); //Persist object - Not persisting asset because of cascade on employee with cascadeType All
		session.save(employee); //Persist object persisting employee because of specified mappedBy from employee side.
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
