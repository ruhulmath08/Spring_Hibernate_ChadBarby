package com.odduu.ruhul.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// setup connection variables
		String user = "hbstudent";
		String pass = "hbstudent";
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";

		// get connection databases
		try {
			PrintWriter out = response.getWriter();
			System.out.println("Connection to database: " + jdbcURL);

			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Success!!!");
			myConn.close();
		} catch (Exception exe) {
			exe.printStackTrace();
			throw new ServletException(exe);
		}

		//
	}

}
