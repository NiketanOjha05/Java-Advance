package in.co.rays.models.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestUpdateMarksheet {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		System.out.println("Connected Successfully : " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(
				"select *, (math + phy + chm) as total from marksheet where math >=33 and phy >=33 and chm >=33 order by total desc limit 0,5");

		while (rs.next()) {

			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("math"));
			System.out.println(rs.getInt("phy"));
			System.out.println(rs.getInt("chm"));

			int total = rs.getInt("math") + rs.getInt("phy") + rs.getInt("chm");
			double persentage = (total / 3);

			System.out.println("Total Numbers :" + total);
			System.out.println("Persentage :" + persentage);

		}
	}

}
