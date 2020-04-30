package com.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.hibernate.entity.Asset;
import com.hibernate.utility.HibernateUtility;

public class EmployeeAssetClientRerieveAsset {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		List<Asset> assetList = new ArrayList<Asset>();
		
		//Client 2 Execution
		System.out.println("=====Through Asset====");
		//Query query1 = session.createQuery("from Asset");
		TypedQuery<Asset> query = session.createQuery("from Asset",Asset.class); //To avoid castException 
		assetList = query.getResultList();
		for (Asset e : assetList) {
			System.out.println(e.getEmployee().getEmployeeId()+", "+e.getEmployee().getEmployeeName()+", "+e.getAssetName()+", "+e.getAssetBrandName());
		}
		
		assetList.stream().forEach(System.out::println); //java - 8
		session.close();
		HibernateUtility.shutdownSessionFactory();
	}

}
