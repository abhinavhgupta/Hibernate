package com.accenture.lkm.hibernate.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.accenture.lkm.hibernate.entity.Employee;

public class HibernateUtility {

	private static StandardServiceRegistry standardRegistry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		Properties properties = new Properties();
		
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatedemos");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		standardRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();

		Metadata metadata = new MetadataSources(standardRegistry).
				addAnnotatedClass(Employee.class)
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
