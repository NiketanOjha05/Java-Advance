package in.co.rays.preparedstatement.doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorModel {

	public void add(long doctorId, String doctorName, String specialization, int experience, String contactNo)
			throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into doctor values (?,?,?,?,?)");

			pstmt.setLong(1, doctorId);
			pstmt.setString(2, doctorName);
			pstmt.setString(3, specialization);
			pstmt.setInt(4, experience);
			pstmt.setString(5, contactNo);

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Record Inserted :" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}
	}

	public void delete(int doctorId) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from doctor where doctorId = ?");

			pstmt.setLong(1, doctorId);

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Record Deleted :" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void update(long doctorId, String doctorName) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update doctor set doctorName = ? where doctorId = ?");

			pstmt.setString(1, doctorName);
			pstmt.setLong(2, doctorId);

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Record Updated :" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}

	}

}
