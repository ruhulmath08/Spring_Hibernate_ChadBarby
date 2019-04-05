package com.ruhul.hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.hibernate.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			// display all students
			System.out.println("Display all students");
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);

			// Display student wth last name: 'Ruhul'
			System.out.println("\n\nDisplay student wth last name: 'Ruhul'");
			theStudents = session.createQuery("from Student s where s.lastName = 'Ruhul'").getResultList();
			displayStudents(theStudents);

			// display students with lastName="Ruhul" OR email="reza@gmail.com"
			System.out.println("\n\nStudents who have last name of : Ruhul OR email of: reza@gmail.com");
			theStudents = session.createQuery("from Student s where s.lastName = 'Ruhul' or s.email = 'reza@gmail.com'")
					.getResultList();
			displayStudents(theStudents);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");

		} finally {
			factory.close();
		}
	}

	// method for display students
	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}
