package com.ruhul.odduu.valuefromproperty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// retrieve bean from spring container
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(swimCoach.getDailyWorout());

		// call a method to the daily fortune
		System.out.println(swimCoach.getDailyFortune());

		// call our SwimCoach methods... has the props values injected
		System.out.println("Email: " + swimCoach.getEmail());
		System.out.println("Team: " + swimCoach.getTeam());

		// close the context
		context.close();
	}
}
