package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;

public class DeleteInstructorDemo {

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
			
			//get instructor by primary key
			int theId = 2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found instructor: "+tempInstructor);
			
			//delete the Instructor
			if(tempInstructor != null) {
				System.out.println("Deleting: "+tempInstructor);
				//Note: will ALSO delete associated "instructorDetails" object
				session.delete(tempInstructor);
			}

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}

}
