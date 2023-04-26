package com.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.EmployeeTracker;

public class ReadEmployeeHibernateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(EmployeeTracker.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Scanner kb = new Scanner(System.in);
		try {
			System.out.println("Creating student object");
//			
//			EmployeeTracker employee_Tracker = new EmployeeTracker("Pranay","Pal","pranaypal13@gmail.com");
//			session.beginTransaction();
//			System.out.println(employee_Tracker);
//			session.save(employee_Tracker);
//			session.getTransaction().commit();
//			
			
			// find the employee id to retrieve the object
			//System.out.println("Employee Saved. Employee Pranay id generated" + employee_Tracker.getId());
			
			// creating a new session and beginning a new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("Enter the id");
			int id = kb.nextInt();
					
			// retrieving the employee based on the id
				System.out.println("Displaying employee pranay id" + id);
						
			// retrieve the object
			EmployeeTracker my_Employee_Tracker = session.get(EmployeeTracker.class, id);
			
			System.out.println("Retrieval completed " + my_Employee_Tracker);

			session.getTransaction().commit();
			
			System.out.println("Done all ");
		}finally {
			factory.close();
		}
	}

}
