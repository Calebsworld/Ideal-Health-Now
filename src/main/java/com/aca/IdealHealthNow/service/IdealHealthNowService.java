package com.aca.IdealHealthNow.service;

import java.util.List;

import com.aca.IdealHealthNow.Exception.DataNotFoundException;
import com.aca.IdealHealthNow.dao.IdealHealthNowDao;
import com.aca.IdealHealthNow.dao.IdealHealthNowDaoImpl;
import com.aca.IdealHealthNow.model.Product;


public class IdealHealthNowService {

	IdealHealthNowDao idealHealthNowDao = new IdealHealthNowDaoImpl();
	
	
	private void validateProductId(Integer id) {
		if (id == null || id <= 0) {
			throw new DataNotFoundException("Not a valid productId '" + id + "'- coachId must be > 0.");
		}  
		boolean doesExist = false;
		List<Product> products = getAllProducts();
		for (Product product : products) {
			if (product.getId().equals(id)) {
				doesExist = true;
			}
		}
		if (!doesExist) {
			throw new DataNotFoundException("Not a valid productId '" + id + "'- productId does not exist");
		}
	}
	
	public List<Product> getAllProducts() {
		return idealHealthNowDao.getAllProducts();
	}
	
	public List<Product> getProductById(Integer id) {
		this.validateProductId(id);
		return idealHealthNowDao.getProductById(id);
	}

	public List<Product> getProductByName(String name) {
		return idealHealthNowDao.getProductByName(name);
	}

	
	public List<Product> getProductsByCategory(String category) {
		return idealHealthNowDao.getProductsByCategory(category);
	}

	
	public Product addProduct(Product product) {
		return idealHealthNowDao.addProduct(product);
	}

	
	public Product removeProductById(Integer id) {
		return idealHealthNowDao.removeProductById(id);
	}

	public List<Product> getProductsByProductType(String productType) {
		return idealHealthNowDao.getProductsByProductType(productType);
	}

	public Product updateProduct(Product product) {
		return idealHealthNowDao.updateProduct(product);
	}


	


	
	
	
	
}
