package com.aca.IdealHealthNow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.aca.IdealHealthNow.model.Product;
import com.aca.IdealHealthNow.model.ProductType;




public class IdealHealthNowDaoImpl implements IdealHealthNowDao {

	private static final String SELECT_ALL_FROM_PRODUCTS = 
			"SELECT id, productName, productType, description, img, updateDateTime, CreateDateTime " +
			"FROM products ";
	
	private static String selectAllProducts = SELECT_ALL_FROM_PRODUCTS;
	
	private static String selectProductById = 
			SELECT_ALL_FROM_PRODUCTS +
			"WHERE id = ? ";
	
	private static String selectProductByProductName = 
			SELECT_ALL_FROM_PRODUCTS +
			"WHERE productName = ? ";
	
	private static String selectProductsByProductType = 
			SELECT_ALL_FROM_PRODUCTS +
			"WHERE productType = ? ";
	
	private static String selectProductsByCategory = 
			SELECT_ALL_FROM_PRODUCTS +
			"WHERE category = ? ";
	
	private static String selectNewProductId = 
			"SELECT LAST_INSERT_ID() AS productId ";
	
	private static String addProduct = 
			"INSERT into products(productName, productType, description, img) " +
			"VALUES " +
			"(?, ?, ?, ?) ";
	
	private static String updateProductById = 
			"UPDATE products " +
			"SET productName = ?, productType = ?, description = ?, img = ? " +
			"WHERE id = ? ";
	
	private static String removeProductById = 
			"DELETE from products " +
			"WHERE id = ? ";
		
	@Override
	public List<Product> getAllProducts() {
		List <Product> products = new ArrayList<>();		
		Statement st = null;
		ResultSet rs = null;
		Connection conn = MariaDbUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(selectAllProducts);
			products = makeProducts(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return products;
	}

	private List<Product> makeProducts(ResultSet rs) throws SQLException {
		List<Product> products = new ArrayList<>();
		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setProductName(rs.getString("productName"));
			String productTypeValue = rs.getString("productType");
			product.setProductType(ProductType.convertStringToProductType(productTypeValue));
			product.setDescription(rs.getString("description"));
			product.setImg(rs.getString("img"));
			product.setUpdateDateTime(rs.getObject("updateDateTime", LocalDateTime.class));
			product.setCreateDateTime(rs.getObject("createDateTime", LocalDateTime.class));
			products.add(product);
		}
		return products;
	}
	
	@Override
	public List<Product> getProductById(Integer id) {
		List<Product> products = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectProductById);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			products = makeProducts(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public List<Product> getProductByName(String productName) {
		List<Product> products = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectProductByProductName);
			ps.setString(1, productName);
			rs = ps.executeQuery();
			products = makeProducts(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}
	
	@Override
	public List<Product> getProductsByProductType(String productType) {
		List<Product> products = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectProductsByProductType);
			ps.setString(1, productType);
			rs = ps.executeQuery();
			products = makeProducts(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> products = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectProductsByCategory);
			ps.setString(1, category);
			rs = ps.executeQuery();
			products = makeProducts(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	private Integer getNewProductId(Connection conn) {
		ResultSet rs = null;
		Statement st = null;
		Integer newProductId = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(selectNewProductId);
			while (rs.next()) {
				newProductId = rs.getInt("productId");
			}
		} catch (SQLException e) {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return newProductId;
	}
	
	
	@Override
	public Product addProduct(Product product) {
		int updateRowCount = 0;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(addProduct);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductType().toString());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getImg());
			updateRowCount = ps.executeUpdate();
			Integer newProductId = getNewProductId(conn);
			product.setId(newProductId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return product;
	}
	
	@Override
	public Product updateProduct(Product product) {
			List<Product> products = this.getProductById(product.getId());
			if (products.size() > 0) {
				int updateRowCount = 0;
				PreparedStatement ps = null;
				Connection conn = MariaDbUtil.getConnection();
				try {
					ps = conn.prepareStatement(updateProductById);
					ps.setString(1, product.getProductName());
					ps.setString(2, product.getProductType().toString());
					ps.setString(3, product.getDescription());
					ps.setString(4, product.getImg());
					ps.setInt(5, product.getId());
					updateRowCount = ps.executeUpdate();
					System.out.println("rows updated: " + updateRowCount);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						ps.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return product;
		}
		

	@Override
	public Product removeProductById(Integer id) {
		List<Product> products = this.getProductById(id);
		Product productToDelete = null;
		if (products.size() > 0) {
			productToDelete = products.get(0);
		}
		int updateRowCount = 0;
		PreparedStatement ps = null;
		Connection conn = MariaDbUtil.getConnection(); 
		try {
			ps = conn.prepareStatement(removeProductById);
			ps.setInt(1, id);
			updateRowCount = ps.executeUpdate();
			System.out.println("rows deleted " + updateRowCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return productToDelete;
	}



	
	



	

	

	

}
