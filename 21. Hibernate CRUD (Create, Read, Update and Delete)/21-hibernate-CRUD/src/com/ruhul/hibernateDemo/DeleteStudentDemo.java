package com.ruhul.hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.hibernate.entity.Student;

public class DeleteStudentDemo {
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
			displayAllStudent(theStudents);
			
			//delete student id=1
			System.out.println("\nDeleting student id=1");
			session.createQuery("delete from Student where id = 1").executeUpdate();
			session.getTransaction().commit();
			
			// display all students
			System.out.println("\nDisplay all students after delete id: 1");
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> theStudentNew = session.createQuery("from Student").getResultList();
			displayAllStudent(theStudentNew);
			session.getTransaction().commit();

			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}

	private static void displayAllStudent(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}
}
