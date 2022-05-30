package com.app.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create object of any entiy class
			Users user = new Users("vishal","pass123","Vishal","Jagadale");
			
			//Start transaction
			session.beginTransaction();
			
			//Perform operation
			session.save(user);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("User added successfully !");
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
