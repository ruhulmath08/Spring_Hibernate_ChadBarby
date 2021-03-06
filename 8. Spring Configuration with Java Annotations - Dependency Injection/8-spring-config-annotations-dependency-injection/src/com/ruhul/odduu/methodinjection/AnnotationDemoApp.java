package com.ruhul.odduu.methodinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring congig file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextMethod.xml");

		// get the bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorout());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}
}
