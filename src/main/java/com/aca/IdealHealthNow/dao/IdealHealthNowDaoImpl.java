package com.aca.IdealHealthNow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aca.IdealHealthNow.model.Appointment;
import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;
import com.aca.IdealHealthNow.model.Product;
import com.aca.IdealHealthNow.model.ProductType;
import com.aca.IdealHealthNow.model.Schedule;


public class IdealHealthNowDaoImpl implements IdealHealthNowDao {

	private static String SelectAllCoaches = 
			"SELECT id, firstName, lastName, updateDateTime, createDateTime " +
			"FROM coaches " ;
	
	private static String SelectCoachById = 
			"SELECT id, firstName, lastName, updateDateTime, createDateTime " +
			"FROM coaches " +
			"WHERE id = ? ";
	
	private static String SelectCoachByFullName = 
			"SELECT id, firstName, lastName, updateDateTime, createDateTime " +
			"FROM coaches " +
			"WHERE firstName = ? AND lastName = ? ";
	
	private static String createCoach =
			"INSERT INTO coaches (firstName, lastName) " +
					"VALUES " +
					"(?, ?)";
	
	private static String selectNewCoachId = 
			"SELECT LAST_INSERT_ID() AS coachId ";
	
	private static String updateCoachById = 
			"UPDATE coaches " +
			"SET firstName = ?, lastName = ? " +
			"WHERE id = ? ";
	
	private static String deleteCoachById = 
			"DELETE FROM coaches " +
			"WHERE id = ? ";
	
	private static String selectAllPatients = 
			"SELECT id, firstName, lastName, emailAddress, phoneNumber, updateDateTime, CreateDateTime " + 
			"FROM patients ";
	
	private static String selectPatientById = 
			"SELECT id, firstName, lastName, emailAddress, phoneNumber, updateDateTime, CreateDateTime " + 
					"FROM patients " + 
					"WHERE id = ? ";
	
	private static String selectPatientByFullName = 
			"SELECT id, firstName, lastName, emailAddress, phoneNumber, updateDateTime, CreateDateTime " + 
					"FROM patients " + 
					"WHERE firstName = ? AND lastName = ? ";
	
	private static String selectNewPatientId = 
			"Select Last_Insert_ID() As patientId ";
	
	private static String createPatient = 
			"INSERT into patients (firstName, lastName, emailAddress, phoneNumber) " +
			"VALUES " + 
			"(?, ?, ?, ?) ";
			
	private static String updatePatientById =
			"Update patients " +
			"SET firstName = ?, lastName = ?, emailAddress = ?, phoneNumber = ? " +
			"WHERE id = ? "; 
	
	private static String deletePatientById =
			"DELETE FROM patients " +
			"WHERE id = ? ";
	
	private static String getAppointmentById;
	
	private static String createAppointment;
	
	private static String updateAppointment;
	
	private static String deleteAppointment;
	
	private static String selectAllProducts = 
			"SELECT id, productName, productType, category, description, updateDateTime, CreateDateTime " + 
			"FROM products ";
	
	private static String selectProductById = 
			"SELECT id, productName, productType, category, description, updateDateTime, CreateDateTime " +
			"FROM products " +
			"WHERE id = ? ";
	
	private static String selectProductByProductName = 
			"Select id, productName, productType, category, description, updateDateTime, CreateDateTime " +
			"FROM products " +
			"WHERE productName = ? ";
	
	private static String selectProductByProductType = 
			"";
	
	private static String selectProductsByCategory = 
			"Select id, productName, productType, category, description, updateDateTime, CreateDateTime " +
			"From products " +
			"WHERE category = ? ";
	
	private static String selectNewProductId = 
			"SELECT LAST_INSERT_ID() AS productId ";
	
	private static String addProduct = 
			"INSERT into products(productName, productType, category, description) " +
			"VALUES " +
			"(?, ?, ?, ?) ";
	
	private static String removeProductById = 
			"DELETE from products " +
			"WHERE id = ? ";
	
	@Override
	public List<Coach> getCoaches() {
		List<Coach> coaches = new ArrayList<>();
		ResultSet rs = null;
		Statement st = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SelectAllCoaches);
			coaches = makeCoaches(rs);
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
		
		return coaches;
	}
	
	private List<Coach> makeCoaches(ResultSet result) throws SQLException {
		List <Coach> coaches = new ArrayList<>();
		while (result.next()) {
			Coach coach = new Coach();
			coach.setCoachId(result.getInt("id"));
			coach.setFirstName(result.getString("firstName"));
			coach.setLastName(result.getString("lastName"));
			coach.setUpdateDateTime(result.getObject("updateDateTime", LocalDateTime.class));
			coach.setCreateDateTime(result.getObject("createDateTime", LocalDateTime.class));
			coaches.add(coach);
		}
		return coaches;
	}
	
	@Override
	public List<Coach> getCoachByFullName(String coachFirstName, String coachLastName) {
		List<Coach> coachesByFullName = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(SelectCoachByFullName);
			ps.setString(1, coachFirstName);
			ps.setString(2, coachLastName);
			rs = ps.executeQuery();
			coachesByFullName = makeCoaches(rs);
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
		
		return coachesByFullName;
	}

	@Override
	public List<Coach> getCoachById(Integer id) {
		List<Coach> coaches = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(SelectCoachById);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			coaches = makeCoaches(rs);
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
	
		return coaches;
	}

	private Integer getNewCoachId(Connection conn) {
		ResultSet rs = null;
		Statement st = null;
		Integer newCoachId = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(selectNewCoachId);
			while (rs.next()) {
				newCoachId = rs.getInt("id");
			}
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
		
		return newCoachId;
	}
	
	@Override
	public Coach createCoach(Coach coach) {
		int updateRowCount = 0;
		Connection conn = MariaDbUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(createCoach);
			ps.setString(1, coach.getFirstName());
			ps.setString(2, coach.getLastName());
			updateRowCount = ps.executeUpdate();
			System.out.println("Rows updated: " + updateRowCount);
			Integer newCoachId = getNewCoachId(conn);
			coach.setCoachId(newCoachId);
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

		return coach;
	}

	@Override
	public Coach updateCoach(Coach updateCoach) {
		List <Coach> coaches = this.getCoachById(updateCoach.getCoachId());
		if (coaches.size() > 0) {
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MariaDbUtil.getConnection();
			try {
				ps = conn.prepareStatement(updateCoachById);
				ps.setString(1, updateCoach.getFirstName());
				ps.setString(2, updateCoach.getLastName());
				ps.setInt(3, updateCoach.getCoachId());
				updateRowCount = ps.executeUpdate();
				System.out.println("Rows updated: " + updateRowCount);
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
		
		return updateCoach;
	}

	@Override
	public Coach deleteCoach(Integer id) {
		List <Coach> coaches = this.getCoachById(id);
		Coach coachToDelete = null;
		if (coaches.size() > 0) {
			coachToDelete = coaches.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MariaDbUtil.getConnection();
			try {
				ps = conn.prepareStatement(deleteCoachById);
				ps.setInt(1, id);
				updateRowCount = ps.executeUpdate();
				System.out.println("Rows updated: " + updateRowCount);
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
		
		return coachToDelete;
	}

	private List<Patient> makePatients(ResultSet rs) throws SQLException {
		List<Patient> patients = new ArrayList<>();
		
		while (rs.next()) {
			Patient patient = new Patient();
			patient.setPatientId(rs.getInt("id"));
			patient.setFirstName(rs.getString("firstName"));
			patient.setLastName(rs.getString("lastName"));
			patient.setEmailAddress(rs.getString("emailAddress"));
			patient.setPhoneNumber(rs.getString("phoneNumber"));
			patient.setUpdateDateTime(rs.getObject("updateDateTime", LocalDateTime.class));
			patient.setCreateDateTime(rs.getObject("createDateTime", LocalDateTime.class));
			patients.add(patient);
			}
		
		return patients;
	}
	
	@Override
	public List<Patient> getPatients() {
			List<Patient> patients = new ArrayList<>();
			ResultSet rs = null;
			Statement st = null;
			
			Connection conn = MariaDbUtil.getConnection();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(selectAllPatients);
				patients = this.makePatients(rs);
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
		
		return patients;
	}

	@Override
	public List<Patient> getPatientsById(Integer id) {
		List<Patient> patients = this.getPatients();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectPatientById);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			patients = makePatients(rs);
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
		
		return patients;
	}

	private Integer getNewPatientId(Connection conn) {
		ResultSet rs = null;
		Statement st = null;
		Integer newPatientId = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(selectNewPatientId);
			while (rs.next()) {
				newPatientId = rs.getInt("id");
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

		return newPatientId;
	}
	
	@Override
	public List<Patient> getPatientsByFullName(String patientFirstName, String patientLastName) {
		List<Patient> patientsByFullName = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectPatientByFullName);
			ps.setString(1, patientFirstName);
			ps.setString(2, patientLastName);
			rs = ps.executeQuery();
			patientsByFullName = makePatients(rs);
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
		
		return patientsByFullName;
	}
	
	@Override
	public Patient createPatient(Patient patient) {
		int updateRowCount = 0;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(createPatient);
			ps.setString(1, patient.getFirstName());
			ps.setString(2, patient.getLastName());
			ps.setString(3, patient.getEmailAddress());
			ps.setString(4, patient.getPhoneNumber());
			updateRowCount = ps.executeUpdate();
			System.out.println("rows updated: " + updateRowCount);
			Integer newPatientId = getNewPatientId(conn);
			patient.setPatientId(newPatientId);
		} catch (SQLException e) {
			e.printStackTrace();
		} try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return patient;
	}

	@Override
	public Patient updatePatient(Patient updatePatient) {
		List<Patient> patients = this.getPatientsById(updatePatient.getPatientId());
		if (patients.size() > 0) {
			int updateRowCount = 0;
			PreparedStatement ps = null;
			Connection conn = MariaDbUtil.getConnection();
			try {
				ps = conn.prepareStatement(updatePatientById);
				ps.setString(1, updatePatient.getFirstName());
				ps.setString(2, updatePatient.getLastName());
				ps.setString(3, updatePatient.getEmailAddress());
				ps.setString(4, updatePatient.getPhoneNumber());
				ps.setInt(5, updatePatient.getPatientId());
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
		return updatePatient;
	}

	@Override
	public Patient deletePatient(Integer id) {
		Patient patientToDelete = null;
		List<Patient> patients = getPatientsById(id);
		if (patients.size() > 0) {
			patientToDelete = patients.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			Connection conn = MariaDbUtil.getConnection(); 
			try {
				ps = conn.prepareStatement(deletePatientById);
				ps.setInt(1, id);
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
		
		return patientToDelete;
	}


	@Override
	public Appointment getAppointmentById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment updateAppointment(Appointment updateAppointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment deleteAppointmentById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

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
			product.setName(rs.getString("productName"));
			String productTypeValue = rs.getString("productType");
			product.setProductType(ProductType.convertStringToProductType(productTypeValue));
			product.setCategory(rs.getString("category"));
			product.setDescription(rs.getString("description"));
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
	public List<Product> getProductByName(String name) {
		List<Product> products = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectProductByProductName);
			ps.setString(1, name);
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
				newProductId = rs.getInt("id");
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
			ps.setString(1, product.getName());
			ps.setString(2, product.getProductType().toString());
			ps.setString(3, product.getCategory());
			ps.setString(4, product.getDescription());
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
