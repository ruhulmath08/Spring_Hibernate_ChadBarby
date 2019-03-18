package com.ruhul.odduu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a new student object
		Student theStudent = new Student();

		// add the student object to the model
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}

	// form processing code
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		// log the input data
		System.out.println("Student Name: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}
}
