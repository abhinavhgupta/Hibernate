package com.hibernate.utility;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.hibernate.entity.Account;
import com.hibernate.entity.CreditAccount;
import com.hibernate.entity.DebitAccount;

public class HibernateUtility {

	private static StandardServiceRegistry standardRegistry = null;
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		Map<String, String> settings = new HashMap<>();
		settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "root");
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedemos");
		settings.put(Environment.HBM2DDL_AUTO, "update");
		settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
		settings.put(Environment.SHOW_SQL, "true");
		standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
		Metadata metadata = new MetadataSources(standardRegistry)
				.addAnnotatedClass(Account.class)  //no scan at package level and as well as no such method to add all classes at a time for adding entities 
				.addAnnotatedClass(DebitAccount.class) // in this current version for programmatic configuration so used thrice for - addAnnotatedClass or addAnnotateclassNames(com.accenture.lkm.entity.Account)
				.addAnnotatedClass(CreditAccount.class)
				.getMetadataBuilder()
				.build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		return sessionFactory;

	}
	public static void shutdownSessionFactory() {
		if (standardRegistry != null)
			StandardServiceRegistryBuilder.destroy(standardRegistry);
	}
	
	
}
