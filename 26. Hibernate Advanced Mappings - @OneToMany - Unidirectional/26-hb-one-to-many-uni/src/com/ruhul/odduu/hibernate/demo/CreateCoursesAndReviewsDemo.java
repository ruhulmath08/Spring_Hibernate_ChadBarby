package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Course;
import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;
import com.ruhul.odduu.hibernate.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String args[]) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			//create a course
			Course tempCourse = new Course("Oracle Certified Java Programmer - JAVA-8");
			
			//add some reviews
			tempCourse.addReview(new Review("Covere total 23 core concept related to Core-Jave"));
			tempCourse.addReview(new Review("Provide Details Note and Source code for each topics"));
			tempCourse.addReview(new Review("Details explanation with real world example"));
			
			//save the course ... and leverage the cascade all
			System.out.println("Saving the courses...");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReview());
			session.save(tempCourse);
			
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
