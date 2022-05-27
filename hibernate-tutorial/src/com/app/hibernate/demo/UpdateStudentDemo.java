package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main (String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId =1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the primary key
			System.out.println("\n Getting student with id : "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student ...");
			myStudent.setFirstName("Abhay");
			
			//commit the transaction
			session.getTransaction().commit();
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			session.createQuery("update Student set email='samemail@email.com'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done !");
			
		}finally {
			factory.close();
		}
	}
}