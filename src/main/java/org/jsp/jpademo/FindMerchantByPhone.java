package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByPhone {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Gst Phone:");
	long phone = sc.nextLong();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createQuery("select m from Merchant m where phone=?1");
	q.setParameter(1, phone);
	Merchant m = (Merchant)q.getSingleResult();
	try {
		System.out.println(m);
	} catch (NoResultException e) {
		System.err.println("No result found");
		// TODO: handle exception
	}
}
}
