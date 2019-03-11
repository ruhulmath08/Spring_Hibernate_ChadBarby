package com.ruhul.odduu.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	// field injection
	@Autowired
	private FortuneService fortuneService;

	// default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
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
