package com.ruhul.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ruhul.aopdemo.dao.AccountDAO;
import com.ruhul.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		theAccountDAO.addSillyMember();
		
		// call the membership business method
		theMembershipDAO.addAccount();

		// close the context
		context.close();
	}

}
