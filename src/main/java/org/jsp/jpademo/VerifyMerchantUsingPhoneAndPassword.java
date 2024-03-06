package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchantUsingPhoneAndPassword {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Phone:");
	long phone = sc.nextLong();
	System.out.println("Enter Password: ");
	String password = sc.next();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createQuery("select m from Merchant m where phone=?1 and password=?2");
	q.setParameter(1, phone);
	q.setParameter(2, password);
	Merchant m = (Merchant)q.getSingleResult();
	try {
		System.out.println("Verification Successful!");
		System.out.println(m);
	}catch(NoResultException exp) {
		System.out.println("Verifaction Failed, invalid credentials");
	}
	sc.close();
}
}
