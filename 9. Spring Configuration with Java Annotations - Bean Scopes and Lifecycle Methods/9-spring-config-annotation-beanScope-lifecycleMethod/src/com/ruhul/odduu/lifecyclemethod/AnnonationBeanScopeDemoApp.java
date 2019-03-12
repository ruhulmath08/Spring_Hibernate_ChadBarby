package com.ruhul.odduu.lifecyclemethod;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnonationBeanScopeDemoApp {

	public static void main(String[] args) {

		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextLifecycleMethod.xml");

		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorout());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}
}
