package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.lazy.Course;
import com.ruhul.odduu.hibernate.entity.lazy.Instructor;
import com.ruhul.odduu.hibernate.entity.lazy.InstructorDetail;

public class LazyDemo {

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

			// get the instructor from DB
			int theID = 1;
			Instructor tempInstructor = session.get(Instructor.class, theID);
			System.out.println("com.ruhul: Instructor: "+tempInstructor);
			
			//get courses for the instructor
			System.out.println("com.ruhul: Courses: "+tempInstructor.getCourses());
			
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
