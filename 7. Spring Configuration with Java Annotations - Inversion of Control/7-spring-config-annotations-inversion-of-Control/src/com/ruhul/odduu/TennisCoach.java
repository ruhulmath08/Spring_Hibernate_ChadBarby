package com.ruhul.odduu;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorout() {
		return "Practice your backhand volley";
	}
}
