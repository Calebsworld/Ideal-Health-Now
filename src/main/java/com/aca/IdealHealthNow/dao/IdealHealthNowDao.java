package com.aca.IdealHealthNow.dao;

import java.time.LocalDateTime;
import java.util.List;


import com.aca.IdealHealthNow.model.Product;



public interface IdealHealthNowDao {

	
	public List<Product> getAllProducts();
	public List<Product> getProductById(Integer id);
	public List<Product> getProductByName(String name);
	public List<Product> getProductsByProductType(String productType);
	public List<Product> getProductsByCategory(String category);
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product removeProductById(Integer id);
	

	
}
