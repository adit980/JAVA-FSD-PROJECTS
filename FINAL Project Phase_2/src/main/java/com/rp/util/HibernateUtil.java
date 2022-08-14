package com.rp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rp.entity.Classes;
import com.rp.entity.Student;
import com.rp.entity.Subject;
import com.rp.entity.Teacher;

public class HibernateUtil {

	public static SessionFactory buildSessionFactory() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		return sessionFactory;
	}
}