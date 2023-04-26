package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.EmployeeTracker;
import com.hibernate.entity.Product;

public class EmployeeHibernateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating studet object");
			
			//EmployeeTracker employee_Tracker = new EmployeeTracker("Panshul","Bharadwaj","prateekpal24@gmail.com");
			
			
			Product p = new Product(11,"good",5000,"LG");
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			System.out.println("Saved the data to the table");
			session.close();
		}finally {
			factory.close();
		}
	}

}
