package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {
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
			
			// Get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// Delete course
			System.out.println("Deleting Course : "+tempCourse);
			
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			factory.close();
		}
	}
}