package com.hibernate.utility;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.hibernate.entity.Employee;

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
		settings.put(Environment.USE_SECOND_LEVEL_CACHE,"true");
		settings.put(Environment.CACHE_PROVIDER_CONFIG, "org.hibernate.cache.EhCacheProvider");
		settings.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		
		standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
		Metadata metadata = new MetadataSources(standardRegistry).addAnnotatedClass(Employee.class).getMetadataBuilder()
				.build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		return sessionFactory;

	}
	public static void shutdownSessionFactory() {
		/*if (standardRegistry != null)
			StandardServiceRegistryBuilder.destroy(standardRegistry);*/
		if(!getSessionFactory().isClosed()) {
			getSessionFactory().close();
		}
		
	}
	
	
}
