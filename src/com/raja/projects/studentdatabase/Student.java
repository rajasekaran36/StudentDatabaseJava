package com.raja.projects.studentdatabase;

import java.util.Scanner;

public class Student {
	String name;
	String phoneNo;
	String email;
	String location;
	
	public Student() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Student Details");
		System.out.print("Name:");
		this.name = input.next();
		System.out.print("PhoneNo:");
		this.phoneNo = input.next();
		System.out.print("Email:");
		this.email = input.next();
		System.out.print("Location:");
		this.location = input.next();
		input.close();
		
	}
	public Student(String name, String phoneNo, String email, String location){
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.location = location;
	}
}
