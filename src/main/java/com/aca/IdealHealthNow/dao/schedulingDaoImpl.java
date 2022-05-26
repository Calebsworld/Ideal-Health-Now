package com.aca.IdealHealthNow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aca.IdealHealthNow.model.Coach;
import com.aca.IdealHealthNow.model.Patient;


public class schedulingDaoImpl implements ShedulingDao {

	private static String SelectAllCoaches = 
			"SELECT id, firstName, lastName, updateDateTime, createDateTime " +
			"FROM coaches " ;
	
	private static String SelectCoachById = 
			"SELECT id, firstName, lastName, updateDateTime, createDateTime " +
			"FROM coaches " +
			"WHERE id = ? ";
	
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
	public List<Coach> getCoaches() {
		List<Coach> coaches = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(SelectAllCoaches);
			coaches = makeCoaches(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return coaches;
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

	@Override
	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatientById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient createPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient updatePatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient deletePatient() {
		// TODO Auto-generated method stub
		return null;
	}

}
