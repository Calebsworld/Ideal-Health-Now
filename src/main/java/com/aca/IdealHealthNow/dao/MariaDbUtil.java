package com.aca.IdealHealthNow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbUtil {

	private static final String CONNECTION_URL =  "jdbc:mariadb://localhost:3306/schedulingapp?user=root&password=Truth4001!";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(CONNECTION_URL);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	
}
