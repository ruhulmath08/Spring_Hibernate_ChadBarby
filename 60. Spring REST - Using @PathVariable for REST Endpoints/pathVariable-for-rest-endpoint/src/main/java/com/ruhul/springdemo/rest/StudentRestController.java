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

	/*
	 * WHY WE USR: @PostConstruct
	 * 
	 * because when the constructor is called, the bean is not yet initialized -
	 * i.e. no dependencies are injected. In the @PostConstruct method the bean is
	 * fully initialized and you can use the dependencies.
	 * 
	 * because this is the contract that guarantees that this method will be invoked
	 * only once in the bean lifecycle. It may happen (though unlikely) that a bean
	 * is instantiated multiple times by the container in its internal working, but
	 * it guarantees that @PostConstruct will be invoked only once.
	 */

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

		// just index into the list ... keep it simple now!!!

		return theStudents.get(studentId);
	}
}
