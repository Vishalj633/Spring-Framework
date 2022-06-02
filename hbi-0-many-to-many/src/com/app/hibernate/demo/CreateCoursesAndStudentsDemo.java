package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;
import com.app.hibernate.demo.entity.Review;
import com.app.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {
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
			
			// Create a course
			Course tempCourse = new Course("JavaScript");
			
			session.save(tempCourse);
			
			// Create students
			Student tempStudent1 = new Student("Vishal","Jagadale","vishaljagdale633@gmail.com");
			Student tempStudent2 = new Student("Saurabh","Dhure","saurabh@gmail.com");
			Student tempStudent3 = new Student("Kamran","Khan","kamran@gmail.com");
			
			// Add students to the course 
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			// Save students
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			session.close();
			factory.close();
		}
	}
}