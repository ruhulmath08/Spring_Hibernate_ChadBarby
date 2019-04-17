package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Course;
import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String args[]) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the instructor from DB
			int theID = 1;
			Instructor tempInstructor = session.get(Instructor.class, theID);

			// create some courses
			Course tempCourse1 = new Course("Adobe Photoshop - The best design for electrical device ever");
			Course tempCourse2 = new Course("Adobe Illstrutor - The best design for printing media ever");

			// add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);

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
