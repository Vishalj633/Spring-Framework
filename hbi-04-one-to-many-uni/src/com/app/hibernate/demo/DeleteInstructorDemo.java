package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDemo {
	public static void main (String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
						

			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId =1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor : "+ tempInstructor);
			
			// Delete instructors 
			System.out.println("deleting : "+tempInstructor);
			// will also delete associated details 
			session.delete(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			factory.close();
		}
	}
}