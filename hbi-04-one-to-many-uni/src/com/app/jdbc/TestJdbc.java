package com.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connection Url : "+ url);
			Connection myConn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection is successful");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
