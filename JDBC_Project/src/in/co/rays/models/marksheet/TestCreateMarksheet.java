package in.co.rays.models.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreateMarksheet {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"create table marksheet(id int primary key, name varchar(45), math int, phy int, chm int)");

		System.out.println("table created" + i + "c");

	}

}
