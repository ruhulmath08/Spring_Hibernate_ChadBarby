package com.ruhul.odduu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectionJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		String username = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Conecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection successful: " + myConn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
