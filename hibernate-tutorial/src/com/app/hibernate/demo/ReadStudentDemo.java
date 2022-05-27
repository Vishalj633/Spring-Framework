package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	public static void main (String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
				/* use the session object to save java object */
			
			// create the student object
			System.out.println("Creating a Student object");
			Student tempStudent = new Student("Vishal","Jagadale","vishaljagdale633@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// My new code
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the primary key
			System.out.println("\n Getting student with id : "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete : "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			factory.close();
		}
	}
}