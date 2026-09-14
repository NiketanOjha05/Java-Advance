package in.co.rays.preparedstatement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rays.utill.JDBCDataSource;

public class CreateService {

	public void createTable() throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"create table service(serviceId int primary key, serviceName varchar(45), price double, description varchar(45),serviceCategory varchar(45))");
			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Table Created : " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			JDBCDataSource.turnRollBack(conn);

		} finally {
			JDBCDataSource.closeconnection(conn);
		}
	}

}
