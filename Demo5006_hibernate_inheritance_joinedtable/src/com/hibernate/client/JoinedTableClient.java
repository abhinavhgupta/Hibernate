package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.CreditAccount;
import com.hibernate.entity.DebitAccount;
import com.hibernate.utility.HibernateUtility;

public class JoinedTableClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		
		DebitAccount debit = new DebitAccount();
		debit.setId(1001);
		debit.setBalance(10000);
		debit.setInterestRate(2.5);
		debit.setOverdraftFee(100);
		debit.setOwner("ABC");
		
		CreditAccount credit = new CreditAccount();
		credit.setId(1002);
		credit.setBalance(1500);
		credit.setCreditLimit(150000);
		credit.setInterestRate(6.5);
		credit.setOwner("ABC");
		
		session.save(debit);
		session.save(credit);
		session.getTransaction().commit();
		
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
