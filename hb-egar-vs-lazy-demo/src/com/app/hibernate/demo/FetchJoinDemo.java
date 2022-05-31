package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {
	public static void main (String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
						
		
			// start a transaction
			session.beginTransaction();
			
			// Get the instructor from db
			int theId = 1;
			Query<Instructor>query = session.createQuery("select i from instructor i "
					+"JOIN FETCH i.courses "
					+"where i.id=:theInstructorId", Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// Execute query and get Instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Instructor : "+tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			factory.close();
		}
	}
}