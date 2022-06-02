package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;
import com.app.hibernate.demo.entity.Review;
import com.app.hibernate.demo.entity.Student;

public class DeleteAgileCourseDemo {
	public static void main (String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
						
		
			
			// start a transaction
			session.beginTransaction();
			
			// Get Agile from database
			int courseId = 1;
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("Loaded course : "+tempCourse);
			
			// Delete the course
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			session.close();
			factory.close();
		}
	}
}