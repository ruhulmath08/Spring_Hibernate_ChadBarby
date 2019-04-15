package com.ruhul.deleteonly.instructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailOnlyDemo {

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
			int theId = 5;
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
