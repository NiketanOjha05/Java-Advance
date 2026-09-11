package in.co.rays.models.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsertIntoCourse {
	
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");

		System.out.println("Connected :" + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into course(courseId, courseName, duration, fees, trainerName) values(101,'BCA','Three Years',20000,'Ravi Singh'),(102,'MCA','Two Years',30000,'Suman Sharma'),(103,'BBA','Three Years',25000,'Rahul Yadav'),(104,'MBA','Two Years',45000,'Shivam Kumar'),(105,'LLB','Four Years',75000,'Rohit Gupta'),(106,'B.Tech','Four Years',65000,'Sanjana Sharma'),(107,'B.Pharm','Four Years',115000,'Sachin Pandey'),(108,'M.Tech','Three Years',95000,'Raghav Chauhan')");

		System.out.println("Data Insert : " + i);

	}


}
