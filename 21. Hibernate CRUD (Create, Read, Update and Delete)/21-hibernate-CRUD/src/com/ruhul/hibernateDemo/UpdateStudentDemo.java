package com.ruhul.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ruhul.hibernate.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;
	
			//start a transaction
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:" + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println(myStudent);
			
			//update student
			System.out.println("\n\nUpdating student...");
			myStudent.setFirstName("Md. Ruhul Amin");
			session.getTransaction().commit();
			System.out.println(myStudent);
			
			
			//update email for all student
			System.out.println("\n\nupdate email for all student");
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email = 'demo_email@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("\n\nDone!!!");
		} 
		finally {
			factory.close();
		}
	}
}
