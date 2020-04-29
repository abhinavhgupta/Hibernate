package com.accenture.lkm.hibernate.client;

import java.time.LocalDate;

import org.hibernate.Session;

import com.accenture.lkm.hibernate.entity.Product;
import com.accenture.lkm.hibernate.utility.HibernateUtility;

public class ProductClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		Product product=new Product("Shampoo","Dove",LocalDate.now());
		session.beginTransaction();
		session.save(product);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
