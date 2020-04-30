package com.hibernate.client;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeClient_1_query_secondlevelcache {

	static Session session = null;
	public static void main(String[] args) {
		
		session = HibernateUtility.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Employee")
				.setCacheable(true)
				.setCacheRegion("allemployee");
		List<Employee> list = query.getResultList();
		list.stream().forEach(System.out::println);
		session.getTransaction().commit();
		session.close();
		
		session = HibernateUtility.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query1 = session.createQuery("from Employee")
				.setCacheable(true)
				.setCacheRegion("allemployee");
		List<Employee> list1 = query1.getResultList();
		list1.stream().forEach(System.out::println);
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}
}
