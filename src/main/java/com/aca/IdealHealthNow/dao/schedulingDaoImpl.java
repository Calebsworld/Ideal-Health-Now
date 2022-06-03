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
import com.aca.IdealHealthNow.model.Schedule;


public class schedulingDaoImpl implements ShedulingDao {

	private static String SelectAllCoaches = 
			"SELECT coachtId, firstName, lastName, updateDateTime, createDateTime " +
			"FROM coaches " ;
	
	private static String SelectCoachById = 
			"SELECT coachId, firstName, lastName, updateDateTime, createDateTime " +
			"FROM coaches " +
			"WHERE patientId = ? ";
	
	private static String SelectCoachByFullName = 
			"SELECT coachId, firstName, lastName, updateDateTime, createDateTime " +
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
			"WHERE coachId = ? ";
	
	private static String deleteCoachById = 
			"DELETE FROM coaches " +
			"WHERE coachId = ? ";
	
	private static String selectAllPatients = 
			"SELECT patientId, firstName, lastName, emailAddress, phoneNumber, updateDateTime, CreateDateTime " + 
			"FROM patients ";
	
	private static String selectPatientById = 
			"SELECT patientId, firstName, lastName, emailAddress, phoneNumber, updateDateTime, CreateDateTime " + 
					"FROM patients " + 
					"WHERE patientId = ? ";
	
	private static String selectPatientByFullName = 
			"SELECT patientId, firstName, lastName, emailAddress, phoneNumber, updateDateTime, CreateDateTime " + 
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
			"WHERE patientId = ? "; 
	
	private static String deletePatientById =
			"DELETE FROM patients " +
			"WHERE patientId = ? ";
	
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
			coach.setCoachId(result.getInt("coachId"));
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
	public List<Coach> getCoachById(Integer coachId) {
		List<Coach> coaches = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(SelectCoachById);
			ps.setInt(1, coachId);
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
				newCoachId = rs.getInt("coachId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	public Coach deleteCoach(Integer coachId) {
		List <Coach> coaches = this.getCoachById(coachId);
		Coach coachToDelete = null;
		if (coaches.size() > 0) {
			coachToDelete = coaches.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MariaDbUtil.getConnection();
			try {
				ps = conn.prepareStatement(deleteCoachById);
				ps.setInt(1, coachId);
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
			patient.setPatientId(rs.getInt("patientId"));
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
	public List<Patient> getPatientsById(Integer patientId) {
		List<Patient> patients = this.getPatients();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectPatientById);
			ps.setInt(1, patientId);
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
				newPatientId = rs.getInt("patientId");
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
	public Patient deletePatient(Integer patientId) {
		Patient patientToDelete = null;
		List<Patient> patients = getPatientsById(patientId);
		if (patients.size() > 0) {
			patientToDelete = patients.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			Connection conn = MariaDbUtil.getConnection(); 
			try {
				ps = conn.prepareStatement(deletePatientById);
				ps.setInt(1, patientId);
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
	public Appointment getAppointmentById(Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Appointment getPatientsByApptDateRange(long startTime, long endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment createNewAppointment(Appointment appt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment updateAppointment(Appointment updateAppt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment deleteAppointmentById(Integer apptId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

}
