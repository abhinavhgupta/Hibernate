package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Location;
import com.hibernate.utility.HibernateUtility;

public class Activity_1 {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Location location = new Location(6, "BDC4");
		Employee employee = new Employee("Rahul","Analyst"); //transient object
		employee.setLocation(location);
		location.setEmployee(employee);
		session.beginTransaction();
		//session.save(asset); //Persist object - Not persisting asset because of cascade on employee with cascadeType All
		session.save(employee); //Persist object persisting employee because of specified mappedBy from employee side.
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
