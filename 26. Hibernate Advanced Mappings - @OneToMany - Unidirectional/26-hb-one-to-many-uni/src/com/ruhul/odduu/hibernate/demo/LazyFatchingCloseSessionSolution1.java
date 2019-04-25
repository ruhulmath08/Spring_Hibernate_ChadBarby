package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Course;
import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;

public class LazyFatchingCloseSessionSolution1 {

	public static void main(String[] args) {

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

			// get the Instructor from DB
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: " + tempInstructor);

			// call the getter() method while session is open
			// get courses for the Instructor
			System.out.println("Courses (Session Open): " + tempInstructor.getCourses());

			// commit the transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			// get courses for the Instructor after session is closed
			System.out.println("Courses (Session Closed): " + tempInstructor.getCourses());
			System.out.println("Done!!!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
