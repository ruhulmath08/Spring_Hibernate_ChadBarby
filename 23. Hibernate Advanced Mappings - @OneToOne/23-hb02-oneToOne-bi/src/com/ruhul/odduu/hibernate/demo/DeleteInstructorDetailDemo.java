package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the InstructorDetail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the InstructorDetail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("The associated Instructor: " + tempInstructorDetail.getInstructor());

			//now let delete the instructorDetail
			System.out.println("Deleting tempInstructorDetail: "+tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			//handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
