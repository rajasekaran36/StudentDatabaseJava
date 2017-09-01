package com.raja.projects.studentdatabase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;

public class StudentDatabaseHelper {
	Connection dbConnection;
	Statement dbStatement;
	ResultSet dbResults;
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
	public boolean pushData(Student a) throws SQLException{
		String queryDataPush = pushQueryBuilder(a);
		if(!isAvailable(a)){
		try {
			
			dbStatement.executeUpdate(queryDataPush);
			System.out.println("Data Pushing Done :" +a.name);
		} catch (SQLException e) {
			System.out.println("Data Pushing Problem :" +a.name);
			e.printStackTrace();
		}
		}
		return true;
	}
	public boolean viewData(){
		String queryDataGet = "select * from studentdetails";
		try {
			dbResults = dbStatement.executeQuery(queryDataGet);
			System.out.println("We got the results");
		} catch (SQLException e) {
			System.out.println("Problem in getting dataset");
		}
		
		System.out.println("Name\t\tPhoneNo\tEmail\tLocation");
		
		try {
			while(dbResults.next()){
				System.out.println(dbResults.getString(1)+"\t\t"+dbResults.getString(2)+"\t"+dbResults.getString(3)+"\t"+dbResults.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Problem in reading dataset");
		}
		return true;
		
	}
	public boolean isAvailable(Student aStudent) throws SQLException{
		
		String matchQuery = "select * from studentdetails where phonenumber like '"+ aStudent.phoneNo+"';";
		dbResults = dbStatement.executeQuery(matchQuery);
		if(dbResults.wasNull())
			return true;
		else
			return false;
	}
}