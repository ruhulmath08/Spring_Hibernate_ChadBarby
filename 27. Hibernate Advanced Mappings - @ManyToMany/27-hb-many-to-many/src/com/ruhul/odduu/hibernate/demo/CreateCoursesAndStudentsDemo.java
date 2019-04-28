package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Course;
import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;
import com.ruhul.odduu.hibernate.entity.Review;
import com.ruhul.odduu.hibernate.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String args[]) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			//create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			// save a course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			// create a students 
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			
			// Add Student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the students
			System.out.println("\nSaving the students ...");			
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saving the students: "+tempCourse.getStudents());
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("com.ruhul: Done!!!");
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
