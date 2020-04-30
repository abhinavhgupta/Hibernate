package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ASSET")
public class Asset {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ASSET_ID")
	private Integer assetId;
	private String assetName;
	private String assetBrandName;
	public Asset() {
	}
	
	public Asset(String assetName, String assetBrandName) {
		super();
		this.assetName = assetName;
		this.assetBrandName = assetBrandName;
	}
	
	public String getAssetBrandName() {
		return assetBrandName;
	}
	public Integer getAssetId() {
		return assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetBrandName(String assetBrandName) {
		this.assetBrandName = assetBrandName;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	

}
