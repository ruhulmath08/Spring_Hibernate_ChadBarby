package com.ruhul.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruhul.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/students" => return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Ruhul", "Amin"));
		theStudents.add(new Student("Rezau", "Islam"));
		theStudents.add(new Student("Osman", "Goni"));
		theStudents.add(new Student("Kapil", "Dev"));
		theStudents.add(new Student("Mezbaul", "Islam"));

		return theStudents;
	}
}
