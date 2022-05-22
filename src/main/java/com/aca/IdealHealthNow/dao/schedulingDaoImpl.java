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
	
	private static String createCoach =
			"INSERT INTO coaches (firstName, lastName) " +
					"VALUES " +
					"(?, ?)";
	

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
	public Coach getCoachById() {
		// TODO Auto-generated method stub
		return null;
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
	public Coach updateCoach() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coach deleteCoach() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatientById() {
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
