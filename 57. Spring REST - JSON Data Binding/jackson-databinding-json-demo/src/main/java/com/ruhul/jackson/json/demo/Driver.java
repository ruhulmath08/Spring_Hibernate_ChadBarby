package com.ruhul.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to java POJO 
			// data/simple-full.json
			Student theStudent = mapper.readValue(new 
					File("data/sample-full.json"), Student.class);
			
			// print the value
			System.out.println("Student Id: " + theStudent.getId());
			System.out.println("Student First Name: " + theStudent.getFirstName());
			System.out.println("Student Last Name: " + theStudent.getLastName());
			System.out.println("Student status: " + theStudent.isActive());
			
			// print Address
			System.out.println(theStudent.getAddress());
			
			// print languages
			System.out.print("Languages: ");
			for (String languages : theStudent.getLanguages()) {
				System.out.print(languages + " ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
