package org.jsp.jpademo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllEmails {
public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createQuery("select m.email from Merchant m");
	List<String>emails = q.getResultList();
	if(emails.size()>0) {
		for(String e: emails) {
			System.out.println(e);
		}
	}
	

}
}
