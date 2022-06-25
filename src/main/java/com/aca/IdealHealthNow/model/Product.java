package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;

public class Product {

	private Integer id;
	private String productName;
	private ProductType productType;
	private String category; 
	private String description;
	private LocalDateTime UpdateDateTime;
	private LocalDateTime CreateDateTime;

	public Product() {

	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getUpdateDateTime() {
		return UpdateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		UpdateDateTime = updateDateTime;
	}

	public LocalDateTime getCreateDateTime() {
		return CreateDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		CreateDateTime = createDateTime;
	}
	
	
	
	
}
