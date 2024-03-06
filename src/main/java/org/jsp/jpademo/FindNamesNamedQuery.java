package org.jsp.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindNamesNamedQuery {
public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createNamedQuery("findNames");
	
	List<String> names = q.getResultList();
	for(String name: names) {
		System.out.println(name);
	}
}
}
