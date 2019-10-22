package com.ruhul.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// inject properties for: coach.name and team.name
	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	// expose new endpoint for "teaminfo"
	@GetMapping("teaminfo")
	public String getTeaminfo() {
		return "Coach name: " + coachName + ", Tean Name: " + teamName;
	}

	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server: " + LocalDateTime.now();
	}

	// expose a new endpoint for "workout"
	@GetMapping("workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!!! Lucky Day!!!";
	}
}
