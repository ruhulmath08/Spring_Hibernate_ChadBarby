package com.ruhul.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ruhul.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = null;
		
		// add try-catch for @AfterThrowing advice
		try {
			// add a boolean flag to simulate exception
			boolean tripWrie = false;
			theAccounts = theAccountDAO.findAccounts(tripWrie);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("---------------------------------------");

		System.out.println(theAccounts);

		System.out.println("\n");

		// close the context
		context.close();
	}

}
