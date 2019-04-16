package com.ruhul.odduu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.odduu.hibernate.entity.Course;
import com.ruhul.odduu.hibernate.entity.Instructor;
import com.ruhul.odduu.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			// create the object
			Instructor tempInstructor = 
					new Instructor("Razaul", "Islam", "reza@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("https://www.graphicsstepbystep.com", 
							"Designing");

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
		} 
		finally {
			//add clean up code
			session.close();
			factory.close();
		}
	}
}
