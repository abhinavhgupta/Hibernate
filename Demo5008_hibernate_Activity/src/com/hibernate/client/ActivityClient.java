package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entity.ContractEmployee;
import com.hibernate.entity.RegularEmployee;
import com.hibernate.utility.HibernateUtility;

public class ActivityClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();

		RegularEmployee regularEmployee = new RegularEmployee();
		regularEmployee.setId(1001);
		regularEmployee.setSalary(1000.0);
		
		ContractEmployee contractEmployee = new ContractEmployee();
		contractEmployee.setId(1002);
		contractEmployee.setSalary(500.0);

		session.save(regularEmployee);
		session.save(contractEmployee);
		session.getTransaction().commit();

		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
