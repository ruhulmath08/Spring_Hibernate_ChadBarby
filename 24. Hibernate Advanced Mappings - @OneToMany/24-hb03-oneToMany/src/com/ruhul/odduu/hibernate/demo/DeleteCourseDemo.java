package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Course;
import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String args[]) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			//get a course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			//delete course
			System.out.println("Deleting course: "+tempCourse);
			session.delete(tempCourse);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
