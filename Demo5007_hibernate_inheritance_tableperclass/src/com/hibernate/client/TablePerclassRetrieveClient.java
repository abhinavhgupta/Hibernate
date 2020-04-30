package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.entity.Account;
import com.hibernate.utility.HibernateUtility;

public class TablePerclassRetrieveClient {
			public static void main(String[] args) {
			Session session = HibernateUtility.getSessionFactory().openSession();
			List<Account> list = new ArrayList<Account>();
			
			Query query = session.createQuery("from Account");
			list = query.getResultList();
			for (Account account : list) {
				System.out.println(account.getId()+", "+account.getBalance()+", "+account.getOwner());
			}
			
			session.close();
			HibernateUtility.shutdownSessionFactory();
		}

}
