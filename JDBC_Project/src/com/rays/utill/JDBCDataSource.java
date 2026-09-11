package com.rays.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class JDBCDataSource {

	public static Connection getConnection() {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.bundle.app");

		Connection conn = null;

		try {

			Class.forName(rb.getString("driver"));
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeconnection(Connection conn) {
		try {
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void turnRollBack(Connection conn) {
		try {
			conn.rollback();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
