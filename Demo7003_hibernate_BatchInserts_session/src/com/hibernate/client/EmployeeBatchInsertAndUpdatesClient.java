package com.hibernate.client;

import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import com.hibernate.entity.Employee;
import com.hibernate.utility.HibernateUtility;

public class EmployeeBatchInsertAndUpdatesClient {

	public static void main(String[] args) {
		//insertEmployees();
		printInsertedRecords();
	}

	private static void insertEmployees() {
		Session session = HibernateUtility.getSessionFactory().openSession().unwrap(Session.class);
		session.getTransaction().begin();
		int batchSize = 25;
		int entityCount = 50;
		for (int i = 0; i < entityCount; i++) {
			Employee employee = new Employee();
			employee.setShares(2);
			session.persist(employee);
			if (i > 0 && i % batchSize == 0) {
				session.flush();
				session.clear();
			}
		}
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}
	
	public static void printInsertedRecords() {
		Session session = HibernateUtility.getSessionFactory().openSession().unwrap(Session.class);
		int batchSize = 50;
		session.getTransaction().begin();
		ScrollableResults scrollableResults=session.createQuery("from Employee")
	               .setCacheMode(CacheMode.IGNORE)
	               .scroll(ScrollMode.FORWARD_ONLY);
		
	         int count=0;
	         
	         while (scrollableResults.next()) {
	            Employee employee = (Employee) scrollableResults.get(0);
	            employee.setShares(5);
	            if (++count % batchSize == 0) {
	               session.flush();
	               session.clear();
	            }
	            System.out.println(employee);
	         }
	    session.getTransaction().commit();
	    scrollableResults.close();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}
	

}
