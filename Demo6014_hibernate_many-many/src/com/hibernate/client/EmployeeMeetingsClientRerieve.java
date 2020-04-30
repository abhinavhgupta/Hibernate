package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Meeting;
import com.hibernate.utility.HibernateUtility;
@SuppressWarnings("unchecked")
public class EmployeeMeetingsClientRerieve {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Employee> list = new ArrayList<Employee>();
		List<Meeting> meetings = new ArrayList<Meeting>();
		
		Query query2 = session.createQuery("from Meeting");
		meetings = query2.getResultList();
		
		System.out.println("==== EmployeeID, EmployeeName, MeetingDate====");
		meetings.stream().forEach(System.out::println);
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
