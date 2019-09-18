package com.ruhul.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that return "Hello WOrld"

	@GetMapping("/")
	public String sayHello() {
		return "Hello User: The world time is: " + LocalDateTime.now();
	}
}
