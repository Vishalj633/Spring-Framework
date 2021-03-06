package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {
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
						
			// create the objects
			Instructor tempInstructor = 
					new Instructor("Vishal", "Jagadale", "vishaljagadale633@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail ("simplified_officially","Love to teach");
					
			// associate the objects together 
			tempInstructor.setInstructordetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();
			
			// save the Instructor
			/* NOTE */
			// This will save InstructorDetail object 
			// due to CascadeType.ALL
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			factory.close();
		}
	}
}