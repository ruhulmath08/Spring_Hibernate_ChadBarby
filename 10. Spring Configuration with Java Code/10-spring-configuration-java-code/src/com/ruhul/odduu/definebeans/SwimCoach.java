package com.ruhul.odduu.definebeans;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	// constructor
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorout() {
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
