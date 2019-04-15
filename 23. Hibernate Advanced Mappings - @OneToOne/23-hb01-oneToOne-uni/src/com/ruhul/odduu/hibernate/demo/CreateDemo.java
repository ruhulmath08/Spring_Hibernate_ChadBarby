package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String args[]) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Instructor tempInstructor = 
					new Instructor("Arif", "Islam", "arif@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("https://www.logicbystep.com", 
							"Playing Game");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start transaction
			session.beginTransaction();

			// save the instructor
			// Note: this will ALSO save the tempInstructorDetail object because of CascadeType.ALL
			System.out.println("Saving instrucror: "+tempInstructor);
			session.save(tempInstructor);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}
}
