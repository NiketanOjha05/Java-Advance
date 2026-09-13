package in.co.rays.preparedstatement.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rays.utill.JDBCDataSource;

public class ProductModel {

	public int nextPk() throws Exception {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(productId) from product ");

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

	public void add(ProductBean bean) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into product values (?,?,?,?,?)");

			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getProductName());
			pstmt.setDouble(3, bean.getPrice());
			pstmt.setInt(4, bean.getQuantity());
			pstmt.setString(5, bean.getCategory());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record inserted : " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.turnRollBack(conn);

		} finally {
			JDBCDataSource.closeconnection(conn);
		}
	}

	public void update(ProductBean bean) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update product set productName = ?, price = ?, quantity = ?, category = ? where productId = ? ");

			pstmt.setString(1, bean.getProductName());
			pstmt.setDouble(2, bean.getPrice());
			pstmt.setInt(3, bean.getQuantity());
			pstmt.setString(4, bean.getCategory());
			pstmt.setInt(5, bean.getProductId());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("Data Update Successfull : " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			JDBCDataSource.turnRollBack(conn);

		} finally {
			JDBCDataSource.closeconnection(conn);
		}

	}

}
