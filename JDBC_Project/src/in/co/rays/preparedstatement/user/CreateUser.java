package in.co.rays.preparedstatement.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUser {

	public void createTable() throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table user(id int primary key,firstName Varchar(45),lastName Varchar(45),loginId Varchar(45),password Varchar (45), dob Date)");

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
