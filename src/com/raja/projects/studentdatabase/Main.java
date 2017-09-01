package com.raja.projects.studentdatabase;

import java.sql.SQLException;


public class Main {
	
	public static void main(String[] args) throws SQLException {
		String userName = "root";
		String passWord = "";
		String DBURL = "jdbc:mysql://localhost/studentdb";
		StudentDatabaseHelper helper = new StudentDatabaseHelper(DBURL, userName, passWord);
		Student s = new Student("Raja", "888928398", "raja@gmail.com", "coimbatore");
		helper.pushData(s);
		helper.viewData();
	}

}
