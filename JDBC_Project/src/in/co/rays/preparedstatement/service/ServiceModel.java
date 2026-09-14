package in.co.rays.preparedstatement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rays.utill.JDBCDataSource;

public class ServiceModel {

	public int nextPk() throws Exception {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max (serviceId) from service");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk + 1;

	}

	public void add(ServiceBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into service values(?,?,?,?,?)");

			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getServiceName());
			pstmt.setDouble(3, bean.getPrice());
			pstmt.setString(4, bean.getDescription());
			pstmt.setString(5, bean.getServiceCategory());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("values inserted : " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			JDBCDataSource.turnRollBack(conn);

		} finally {
			JDBCDataSource.closeconnection(conn);
		}
	}

	public void update(ServiceBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update service set serviceName = ?, price = ?, description = ?, serviceCategory = ? where serviceId = ?");

			pstmt.setString(1, bean.getServiceName());
			pstmt.setDouble(2, bean.getPrice());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getServiceCategory());
			pstmt.setInt(5, bean.getServiceId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Data Update Successfully : " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			JDBCDataSource.turnRollBack(conn);

		} finally {
			JDBCDataSource.closeconnection(conn);
		}

	}

}
