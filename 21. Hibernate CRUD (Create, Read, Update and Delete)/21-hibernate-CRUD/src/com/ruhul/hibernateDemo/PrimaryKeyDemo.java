package com.ruhul.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.hibernateCRUD.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Md. Ruhul Amin", "Ruhul", "ruhul@gmail.com");
			Student tempStudent1 = new Student("Md. Rezaul Islam", "Reza", "reza@gmail.com");
			Student tempStudent2 = new Student("Md. Ariful Islam", "Arif", "arif@gmail.com");
			Student tempStudent3 = new Student("Md. Rafiul Islam", "Rafi", "rafi@gmail.com");

			// start transaction
			session.beginTransaction();

			// save the student
			System.out.println("Save the student...");
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}
}
