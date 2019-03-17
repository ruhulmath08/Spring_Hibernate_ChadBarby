package com.ruhul.odduu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// add a controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDaude(@RequestParam("studentName") String theName, Model model) {

		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Hello Programmer " + theName;

		// add the message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
}
