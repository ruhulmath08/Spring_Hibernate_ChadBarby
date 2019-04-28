package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Course;
import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;
import com.ruhul.odduu.hibernate.entity.Review;
import com.ruhul.odduu.hibernate.entity.Student;

public class GetCoursesForMaryDemo {

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
			
			// get the student from database
			int studentId = 1;

			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoad student: "+tempStudent);
			System.out.println("Courses: "+tempStudent.getCourses());
			
			//
			
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
