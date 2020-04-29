package com.accenture.lkm.hibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtility {

	private static StandardServiceRegistry standardRegistry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
	 standardRegistry = new StandardServiceRegistryBuilder()
        .configure() // configures settings from hibernate.cfg.xml
        .build();

	 Metadata metadata = new MetadataSources( standardRegistry )
    .getMetadataBuilder()
    .build();
	 
	 sessionFactory = metadata.getSessionFactoryBuilder().build();
	return sessionFactory;
	
	}
	
	public static void shutdownSessionFactory(){
		if(standardRegistry != null)
			StandardServiceRegistryBuilder.destroy(standardRegistry);
	}
	
	
	
}
