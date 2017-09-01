package com.raja.projects.studentdatabase;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;

public class StudentDatabaseHelper {
	Connection dbConnection;
	Statement dbStatement;
	public StudentDatabaseHelper(String DBURL, String userName, String passWord){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded ...");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Problem");
		}
		
		try {
			dbConnection = (Connection) DriverManager.getConnection(DBURL, userName, passWord);
			System.out.println("Connection Done");
		} catch (SQLException e) {
			System.out.println("Connection Problem");
		}
		try {
			dbStatement = (Statement) dbConnection.createStatement();
			System.out.println("Statement Done");
		} catch (SQLException e) {
			System.out.println("Statement Problem");
		}
	}
	static String pushQueryBuilder(Student aStudent){
		String pushQuery = "";
		pushQuery = "INSERT INTO `studentdetails`(`name`, `phonenumber`, `email`, `location`) VALUES ('"+aStudent.name+"', "+aStudent.phoneNo+", '"+aStudent.email+"', '"+aStudent.location+"')";
		return pushQuery;
		
	}
	public boolean pushData(Student a){
		String queryDataPush = pushQueryBuilder(a);
		try {
			dbStatement.executeUpdate(queryDataPush);
			System.out.println("Data Pushing Done :" +a.name);
		} catch (SQLException e) {
			System.out.println("Data Pushing Problem :" +a.name);
			e.printStackTrace();
		}
		return true;
	}
}
