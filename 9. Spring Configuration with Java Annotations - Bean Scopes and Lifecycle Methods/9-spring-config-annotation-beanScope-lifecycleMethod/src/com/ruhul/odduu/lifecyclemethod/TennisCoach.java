package com.ruhul.odduu.lifecyclemethod;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	// field injection
	@Autowired
	private FortuneService fortuneService;

	// default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// code will execute after constructor and after injection of dependencies
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of constructor doMyStartupStuff()");
	}

	// code will execute before bean destroyed
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of constructor doMyCleanupStuff()");
	}

	@Override
	public String getDailyWorout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
