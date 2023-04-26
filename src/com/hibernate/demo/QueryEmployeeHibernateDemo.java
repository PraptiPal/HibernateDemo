package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.EmployeeTracker;

public class QueryEmployeeHibernateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(EmployeeTracker.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// query through the employees
			List<EmployeeTracker> theEmployees = session.createQuery("from EmployeeTracker").list();
			
			// display the employees list
			
			for(EmployeeTracker employee : theEmployees) {
				System.out.println(employee);
			}
			
			// query the employee with first name = "prateek"
			
//			theEmployees = session.createQuery("from EmployeeTracker et where et.first_Name = 'Prateek'").list();
//			
//			// display the employee with first name = "prateek"
//				System.out.println(theEmployees);
//			
			session.getTransaction().commit();
			
			System.out.println("Done all ");
		}finally {
			factory.close();
		}
	}

}
