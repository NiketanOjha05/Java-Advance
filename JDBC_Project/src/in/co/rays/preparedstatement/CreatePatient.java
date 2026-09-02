package in.co.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatePatient {
	
	public void createTable() throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("CREATE TABLE patient (" + "patientId BIGINT PRIMARY KEY, "
					+ "patientName VARCHAR(100), " + "age INT, " + "disease VARCHAR(100))");

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Table Created :" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}

	}

}
