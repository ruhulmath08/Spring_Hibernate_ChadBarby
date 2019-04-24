package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ruhul.odduu.hibernate.entity.lazy.Course;
import com.ruhul.odduu.hibernate.entity.lazy.Instructor;
import com.ruhul.odduu.hibernate.entity.lazy.InstructorDetail;

public class LazyFatchingCloseSessionSolution2 {

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
			
			// Option-2: Hibernate query with HQL
			
			// get the Instructor from DB
			int theId = 1;
			
			// Hibernate query HQL
			Query<Instructor> query = 
					session.createQuery("SELECT i FROM Instructor i "
							+ "JOIN FETCH i.courses "
							+ "WHERE i.id=:theInstructorId", Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get Instructor
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("Instructor: " + tempInstructor);			
			
			// commit the transaction
			session.getTransaction().commit();

			// close the session
			session.close();
			
			System.out.println("\nMessage: The session is now closed!!!\n");

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
