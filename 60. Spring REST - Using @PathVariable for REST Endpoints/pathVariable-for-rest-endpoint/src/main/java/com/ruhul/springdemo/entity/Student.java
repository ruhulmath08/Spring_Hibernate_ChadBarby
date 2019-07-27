package com.ruhul.springdemo.entity;

public class Student {

	private String firstName;
	private String laseName;

	public Student() {

	}

	public Student(String firstName, String laseName) {
		this.firstName = firstName;
		this.laseName = laseName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLaseName() {
		return laseName;
	}

	public void setLaseName(String laseName) {
		this.laseName = laseName;
	}
}
