package in.co.rays.preparedstatement.patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientModel {

	public int nextpk() throws Exception {
		Connection conn = null;
		int pk = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select max(patientId) from patient");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			conn.close();

		}
		return pk + 1;
	}

	public void add(PatientBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into patient values (?,?,?,?)");

//			pstmt.setInt(1, nextpk());

			pstmt.setInt(1, bean.getPatientId());
			pstmt.setString(2, bean.getPatientName());
			pstmt.setInt(3, bean.getAge());
			pstmt.setString(4, bean.getDisease());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record inserted :" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}
	}

	public void update(PatientBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("update patient set patientName =?,age =?,disease=? where patientId=? ");

			pstmt.setString(1, bean.getPatientName());
			pstmt.setInt(2, bean.getAge());
			pstmt.setString(3, bean.getDisease());
			pstmt.setInt(4, bean.getPatientId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored updated successfully: " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();

		}

	}

}
