package com.raja.projects.studentdatabase;


public class Main {
	
	public static void main(String[] args) {
		String userName = "root";
		String passWord = "";
		String DBURL = "jdbc:mysql://localhost/studentdb";
		StudentDatabaseHelper helper = new StudentDatabaseHelper(DBURL, userName, passWord);
		Student s = new Student("Raja", "888928398", "raja@gmail.com", "coimbatore");
		helper.pushData(s);
	}

}
