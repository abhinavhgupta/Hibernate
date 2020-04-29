package com.accenture.lkm.hibernate.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private int productId;
	@Column(name = "PRODUCT_TYPE")
	private String productType;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_ADDED_DATE")
	private LocalDate productAddedDate;
	public Product() {
	}
	
	public Product(String productType, String productName, LocalDate productAddedDate) {
		this.productType = productType;
		this.productName = productName;
		this.productAddedDate = productAddedDate;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public LocalDate getProductAddedDate() {
		return productAddedDate;
	}
	public void setProductAddedDate(LocalDate productAddedDate) {
		this.productAddedDate = productAddedDate;
	}
	

}
