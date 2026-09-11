package in.co.rays.models.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCustomer {

	public static void main(String[] args) throws Exception {

		// create();
		// insert();
		// search();
		// update();
		// delete();

	}

	private static void create() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collection", "root", "root");
		System.out.println("Connected :" + conn.getCatalog());
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"create table customer(customerId int,customerName varchar(45),email varchar(45),phoneNo varchar(45),address varchar(45))");
		System.out.println("Table Created :" + i);
	}

	private static void insert() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collection", "root", "root");
		System.out.println("Connected :" + conn.getCatalog());
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("");
		System.out.println("Table Update Successfull :" + i);

	}

}
