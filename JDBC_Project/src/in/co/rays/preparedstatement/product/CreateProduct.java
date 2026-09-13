package in.co.rays.preparedstatement.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rays.utill.JDBCDataSource;

public class CreateProduct {

	public void createTable() throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"Create table product(productId int primary key, productName varchar(45), price double, quantity int, category varchar(45))");

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("Table Created : " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}
	}

}
