package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDoctor {
	
	public static void main(String[] args) throws Exception {
//		create();
//		insert();
		search();
//      update();
	}

	private static void create() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		System.out.println("Connection Successful : " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"create table doctor (doctorId long, doctorName Varchar(45),specialization varchar(45),experience int, contactNo Varchar(45))");

		System.out.println("Table Created Successfull : " + i);

	}

	private static void insert() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		System.out.println("Connection Successful : " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into doctor(doctorId,doctorName,specialization,experience,contactNo) values (1001,'Suneel Kumar','Dentist',3,'5373536373'),(1002,'Rakesh Saran','Cardiologist',2,'6755456352'),(1003,'Shivam Sharma','Pediatrician',5,'5365353754'),(1004,'Ram Bhardwaj','Orthopedic',4,'3243565423'),(1005,'Soham Rao','Dermatologist',6,'5634238767')");

		System.out.println("Data insert into Doctor Successfull : " + i);

	}

	private static void search() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		System.out.println("Connection Successful : " + conn.getCatalog());
		
		System.out.println("=====================");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select*from Doctor");

		while (rs.next()) {

			System.out.println(rs.getLong("doctorId"));
			System.out.println(rs.getString("doctorName"));
			System.out.println(rs.getString("specialization"));
			System.out.println(rs.getInt("experience"));
			System.out.println(rs.getString("contactNo"));

		}

	}
	
	private static void update()throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		System.out.println("Connection Successful : " + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update doctor set doctorName = 'Kishan Rana' where doctorId = 1004");
		
		System.out.println("Name Update Successfully :" +i);
	}
	

}
