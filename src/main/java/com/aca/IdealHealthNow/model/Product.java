package com.aca.IdealHealthNow.model;

import java.time.LocalDateTime;

public class Product {

	private Integer id;
	private String productName;
	private ProductType productType;
	private String description;
	private String img;
	private String quantity;
	private LocalDateTime UpdateDateTime;
	private LocalDateTime CreateDateTime;

	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
