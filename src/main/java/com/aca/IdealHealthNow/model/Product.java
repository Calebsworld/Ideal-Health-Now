package com.aca.IdealHealthNow.model;

public class Product {

	private Integer id;
	private String productName;
	private ProductType productType;
	private String category; 
	private String description;
	
	public Product() {
		
	}
	
	public Product(String productName, ProductType productType, String category, String description) {
		this.productName = productName;
		this.productType = productType;
		this.category = category;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return productName;
	}
	public void setName(String productName) {
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
	
	
}
