package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {
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
			
			// Get the instructor detail object
			int theId=2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// Print instructor detail
			System.out.println("temInstructorDeatil : "+tempInstructorDetail); 
			
			// Print associated instructor
			System.out.println("Instructor : "+tempInstructorDetail.getInstructor());;
			
			// Delete the InstructorDetail
			// Remove the associated object reference
			// Break the bidirectional link
			tempInstructorDetail.getInstructor().setInstructordetail(null);
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}