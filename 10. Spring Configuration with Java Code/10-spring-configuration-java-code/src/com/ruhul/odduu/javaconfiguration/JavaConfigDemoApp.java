package com.ruhul.odduu.javaconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorout());

		// call a method to the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}
}
