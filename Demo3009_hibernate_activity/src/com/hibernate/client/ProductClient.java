package com.hibernate.client;

import java.time.LocalDate;

import org.hibernate.Session;

import com.hibernate.entity.Product;
import com.hibernate.utility.HibernateUtility;

public class ProductClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(new Product("Shampoo","Dove",LocalDate.now()));
		session.save(new Product("Soap","Dove",LocalDate.now()));
		session.save(new Product("Moisture","Dove",LocalDate.now()));
		session.save(new Product("Cream","Dove",LocalDate.now()));
		session.save(new Product("Conditioner","Dove",LocalDate.now()));
		session.save(new Product("Shampoo","Dove",LocalDate.now()));
		
	//	session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
