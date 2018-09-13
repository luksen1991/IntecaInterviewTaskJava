package com.example.Family.Utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.example.Family.Entities.Child;


public class HibernateUtil {

	@PersistenceContext
	private static EntityManager entityManager;
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static void initManager() {
		// TODO Auto-generated method stub
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
	}
	public static void shutdown() {
		entityManager.close();
		entityManagerFactory.close();
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
	
//
//	public static void getEntityManager() {
//		// TODO Auto-generated method stub
//		entityManager.getTransaction().begin();
//		
//	}
//	
//	public static void shutdown() {
//		
//	}

	
}
