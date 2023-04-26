package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.EmployeeTracker;

public class DeleteEmployeeHibernateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate-config.xml")
				.addAnnotatedClass(EmployeeTracker.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 5;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieving the employee based on the id
			//System.out.println("Displaying employee pranay id" + employeeId);
			
			 //retrieve the object
			EmployeeTracker my_Employee_Tracker = session.get(EmployeeTracker.class, employeeId);
			
			System.out.println("Deleting employee " + my_Employee_Tracker);
			 session.delete(my_Employee_Tracker);

//			System.out.println("Deleting employee with employee id 6");
//			session.createQuery("delete from EmployeeTracker where id = 6").executeUpdate();
			session.getTransaction().commit();
//			
			System.out.println("Done all ");
		}finally {
			factory.close();
		}
	}

}
