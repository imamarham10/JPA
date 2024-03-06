package org.jsp.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAllNames {
public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createQuery("select m.name from Merchant m");
	List<String>names = q.getResultList();
	if(names.size()>0) {
		for(String name: names) {
			System.out.println(name);
		}
	}else {
		System.out.println("No record found");
	}
}
}
