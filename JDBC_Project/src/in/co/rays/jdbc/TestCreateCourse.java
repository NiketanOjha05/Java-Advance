package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreateCourse {
	
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		System.out.println("Connection Succesfull : " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"create table course(courseId int primary key,courseName Varchar(45),duration Varchar(45),fees double,trainerName Varchar (45))");

		System.out.println("Table Created : " + i);
	}


}
