package com.odduu.ruhul;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

		// call method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		// call our methods to get literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());

		// close the context
		context.close();
	}
}

/*
 Output:
 
CricketCoach: inside no-arg constructor
CricketCoach: inside setter method - setFortuneService
CricketCoach: inside setter method - setEmailAddress
CricketCoach: inside setter method - setTeam
Practice fast bowling for 15 minutes
Today is your lucky day!
ruhulmath08@gmail.com
Dhaka Tigers
 */