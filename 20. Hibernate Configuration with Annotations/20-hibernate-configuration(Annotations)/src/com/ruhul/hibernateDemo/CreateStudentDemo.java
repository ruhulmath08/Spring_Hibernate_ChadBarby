package com.ruhul.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		//create session
		Session session = factory.getCurrentSession();

		try {

			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Md. Rezaul Islam", "Reza", "reza@gmail.com");

			// start transaction
			session.beginTransaction();

			// save the student
			System.out.println("Save the student...");
			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}
}
