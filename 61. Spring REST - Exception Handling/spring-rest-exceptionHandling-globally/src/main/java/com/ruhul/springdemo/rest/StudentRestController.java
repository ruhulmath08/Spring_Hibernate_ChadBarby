package com.ruhul.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruhul.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PostConstruct to load the student data ... only once
	@PostConstruct
	private void loadData() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Ruhul", "Amin"));
		theStudents.add(new Student("Rezau", "Islam"));
		theStudents.add(new Student("Osman", "Goni"));
		theStudents.add(new Student("Kapil", "Dev"));
		theStudents.add(new Student("Mezbaul", "Islam"));
	}

	// define endpoint for "/students" => return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;
	}

	// define endpoint for "/students/{studentId}" => return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// check the studentId against list size
		if (studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student ID not found: " + studentId);
		}

		return theStudents.get(studentId);
	}
}
