package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.EmployeeTracker;

public class UpdateEmployeeHibernateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(EmployeeTracker.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//int employeeId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieving the employee based on the id
			//System.out.println("Displaying employee prapti id" + employeeId);
			
			// retrieve the object
//			EmployeeTracker my_Employee_Tracker = session.get(EmployeeTracker.class, employeeId);
//			
//			System.out.println("Updating employee ");
//			 my_Employee_Tracker.setFirst_Name("Prapti");

			 
			session.createQuery("update EmployeeTracker set first_Name = 'laghima' where id = 1").executeUpdate();
			session.getTransaction().commit();
			
			
			/**
			 * session = factory.getCurrentSession();
			 * session.beginTransaction();
			 Update email for all employees query
			 session.createQuery("update Employee_Tracker set email = 'this@gmail.com'")
			 .executeUpdate(); 
			 session.getTransaction.commit();
			 			 **/
			
			System.out.println("Done all ");
		}finally {
			factory.close();
		}
	}

}
