package com.ruhul.odduu.beanscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnonationBeanScopeDemoApp {

	public static void main(String[] args) {

		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanScope.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

		// check if they are the same
		boolean resut = (theCoach == alphaCoach);
		System.out.println("Point to the same object: " + resut);

		// memory address of bean
		System.out.println("Memory location of theCoach: " + theCoach);
		System.out.println("Memory location of theCoach: " + alphaCoach);

		// close the context
		context.close();
	}
}
