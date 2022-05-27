package com.app.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Student;

public class QueryStudentDemo {
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
			
			// Start transaction
			session.beginTransaction();
			
			// Query Student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// Display the students
			displayStudents(theStudents);
			
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Jagadale'").getResultList();
			
			// Display students
			displayStudents(theStudents);
			
			// query students lastName=Dhure or firstName=Vishal
			theStudents = session.createQuery("from Student s where"
					+ " s.lastName='Dhure' OR firstName='Vishal'").getResultList();
			
			// Display Students
			displayStudents(theStudents);
			
			// query students where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmail.com'").getResultList();
			
			// Display Students
			displayStudents(theStudents);
			
			// Commit the transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}
}