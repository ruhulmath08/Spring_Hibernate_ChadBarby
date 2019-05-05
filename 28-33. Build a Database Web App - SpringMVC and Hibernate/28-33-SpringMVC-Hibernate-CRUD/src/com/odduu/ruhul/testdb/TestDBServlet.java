package com.odduu.ruhul.testdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
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

		// get connection to database
		try {
			System.out.println("Connection to database: " + jdbcURL);

			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Success!!!");
			myConn.close();
		} catch (Exception exe) {
			exe.printStackTrace();
			throw new ServletException(exe);
		}
	}

}
