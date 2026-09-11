package in.co.rays.models.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsertIntoMarksheet {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		System.out.println("Connected Successful : " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into marksheet  ( id , name, math, phy, chm ) values (1,'Ram',76,85,68),(2,'Chetan',34,56,76),(3,'Rahul',45,87,90),(4,'Kusum',56,78,95),(5,'Ayush',32,55,87),(6,'Ketan',67,98,69),(7,'Kavya',30,45,76),(8,'Yuvraj',75,87,98),(9,'Sourav',65,27,42),(10,'Chhavi',87,92,99)");

		System.out.println("Values Insert Successful : " + i);
	}

}
